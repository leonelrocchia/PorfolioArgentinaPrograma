package com.porfolioAP.backAP.Security.Service;

import com.porfolioAP.backAP.Security.Entity.Usuario;
import com.porfolioAP.backAP.Security.Repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    IUsuarioRepository iUsuarioRepository;

    public Optional<Usuario> getByUsername(String username){
        return iUsuarioRepository.findByUsername(username);
    }

    public boolean existsByUsername(String username){
        return iUsuarioRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email){
        return iUsuarioRepository.existsByEmail(email);
    }

    public void save(Usuario usuario){
        iUsuarioRepository.save(usuario);
    }
}
