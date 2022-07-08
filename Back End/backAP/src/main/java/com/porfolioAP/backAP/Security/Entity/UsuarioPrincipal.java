package com.porfolioAP.backAP.Security.Entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.Id;
import javax.persistence.Entity;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class UsuarioPrincipal implements UserDetails {

    @Id
    private int id;
    private String nombre;
    private String username;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    //Constructores


    public UsuarioPrincipal() {
    }

    public UsuarioPrincipal(String nombre, String username, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    //Método para construir un usuario con sus roles

    public static UsuarioPrincipal build(Usuario usuario){
        List<GrantedAuthority> authorities = usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name())).collect(Collectors.toList());
        return new UsuarioPrincipal(usuario.getNombre(), usuario.getUsername(), usuario.getEmail(), usuario.getPassword(), authorities);
    }


    //Métodos declarados en UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }


    //Getter & setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
