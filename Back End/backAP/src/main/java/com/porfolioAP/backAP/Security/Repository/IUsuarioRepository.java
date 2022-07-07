package com.porfolioAP.backAP.Security.Repository;

import com.porfolioAP.backAP.Security.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUsername(String username);

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
