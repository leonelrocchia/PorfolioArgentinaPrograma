package com.porfolioAP.backAP.Controller;

import com.porfolioAP.backAP.Entity.Experience;
import com.porfolioAP.backAP.Interface.ExperienceIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienceController {
    @Autowired ExperienceIService experienceIService;

    @GetMapping("/experience/get")
    public List<Experience> getExperience(){
        return experienceIService.getExperience();
    }

    @PostMapping("/experience/create")
    public String createExperience(@RequestBody Experience experience){
        experienceIService.saveExperience(experience);
        return "El componente de experiencia laboral ha sido creado exitósamente.";
    }

    @DeleteMapping("/experience/delete/{id}")
    public String deleteExperience(@PathVariable Long id){
        experienceIService.deleteExperience(id);
        return "El componente de experiencia laboral ha eliminado exitósamente.";
    }

    @PutMapping("/experience/edit/{id}")
    public Experience editExperience(@PathVariable Long id,
                                   @RequestParam("ex_puesto") String newExPuesto,
                                   @RequestParam("ex_empresa") String newExEmpresa,
                                   @RequestParam("ex_tipo") String newExTipo,
                                   @RequestParam("ex_descripcion") String newExDescripcion,
                                   @RequestParam("ex_img") String newExImg,
                                   @RequestParam("ex_inicio") String newExInicio,
                                   @RequestParam("ex_final") String newExFinal){
        Experience experience = experienceIService.findExperience(id);

        experience.setEx_puesto(newExPuesto);
        experience.setEx_empresa(newExEmpresa);
        experience.setEx_tipo(newExTipo);
        experience.setEx_descripcion(newExDescripcion);
        experience.setEx_img(newExImg);
        experience.setEx_inicio(newExInicio);
        experience.setEx_final(newExFinal);

        experienceIService.saveExperience(experience);
        return experience;
    }

    //@GetMapping("/experience/get/experiences")
    //public Experience findExperience(){
    //   return experienceIService.findExperience((long)id);
    //}
}
