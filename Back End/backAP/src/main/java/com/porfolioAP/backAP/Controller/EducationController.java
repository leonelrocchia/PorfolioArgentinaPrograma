package com.porfolioAP.backAP.Controller;

import com.porfolioAP.backAP.Entity.Education;
import com.porfolioAP.backAP.Interface.EducationIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EducationController {
    @Autowired EducationIService educationIService;

    @GetMapping("/education/get")
    public List<Education> getEducation(){
        return educationIService.getEducation();
    }

    @PostMapping("/education/create")
    public String createEducation(@RequestBody Education education){
        educationIService.saveEducation(education);
        return "El componente educación ha sido creado exitósamente.";
    }

    @DeleteMapping("/education/delete/{id}")
    public String deleteEducation(@PathVariable Long id){
        educationIService.deleteEducation(id);
        return "El componente educación ha sido eliminado exitósamente.";
    }

    @PutMapping("/education/edit/{id}")
    public Education editEducation(@PathVariable Long id,
                         @RequestParam("ed_titulo") String newEdTitulo,
                         @RequestParam("ed_institucion") String newEdInstitucion,
                         @RequestParam("ed_tipo") String newEdTipo,
                         @RequestParam("ed_descripcion") String newEdDescripcion,
                         @RequestParam("ed_img") String newEdImg,
                         @RequestParam("ed_inicio") String newEdInicio,
                         @RequestParam("ed_final") String newEdFinal){
        Education education = educationIService.findEducation(id);

        education.setEd_titulo(newEdTitulo);
        education.setEd_institucion(newEdInstitucion);
        education.setEd_tipo(newEdTipo);
        education.setEd_descripcion(newEdDescripcion);
        education.setEd_img(newEdImg);
        education.setEd_inicio(newEdInicio);
        education.setEd_final(newEdFinal);

        educationIService.saveEducation(education);
        return education;
    }

    //@GetMapping("/education/get/educaciones")
    //public Education findEducation(){
    //   return educationIService.findEducation((long)id);
    //}
}
