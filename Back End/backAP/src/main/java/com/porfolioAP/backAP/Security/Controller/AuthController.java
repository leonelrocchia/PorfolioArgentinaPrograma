package com.porfolioAP.backAP.Security.Controller;

import com.porfolioAP.backAP.Security.Dto.JwtDto;
import com.porfolioAP.backAP.Security.Dto.LoginUsuario;
import com.porfolioAP.backAP.Security.Dto.NuevoUsuario;
import com.porfolioAP.backAP.Security.Entity.Rol;
import com.porfolioAP.backAP.Security.Entity.Usuario;
import com.porfolioAP.backAP.Security.Enums.RolNombre;
import com.porfolioAP.backAP.Security.Service.RolService;
import com.porfolioAP.backAP.Security.Service.UsuarioService;
import com.porfolioAP.backAP.Security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;

    //Método para crear un usuario nuevo
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
        if (usuarioService.existsByUsername(nuevoUsuario.getUsername()))
            return new ResponseEntity(new Mensaje("Ese Username ya existe."),HttpStatus.BAD_REQUEST);
        if (usuarioService.existsByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity(new Mensaje("Ese Email ya está registrado."),HttpStatus.BAD_REQUEST);

        Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getUsername(), nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));

        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());

        if (nuevoUsuario.getRoles().contains("admin"))roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);

        return new ResponseEntity(new Mensaje("Usuario guardado."), HttpStatus.CREATED);

    }

    //Creamos login
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal puestos"), HttpStatus.BAD_REQUEST);

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginUsuario.getUsername(), loginUsuario.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateToken(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(),userDetails.getAuthorities());

        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }



}
