package com.porfolioAP.backAP.Security.Repository;

import com.porfolioAP.backAP.Security.Entity.Rol;
import com.porfolioAP.backAP.Security.Enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
