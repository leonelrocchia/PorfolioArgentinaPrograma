package com.porfolioAP.backAP.Security.Service;

import com.porfolioAP.backAP.Security.Entity.Rol;
import com.porfolioAP.backAP.Security.Enums.RolNombre;
import com.porfolioAP.backAP.Security.Repository.IRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RolService {
    @Autowired
    IRolRepository iRolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return iRolRepository.findByRolNombre(rolNombre);
    }

    public void  save(Rol rol){
        iRolRepository.save(rol);
    }
}
