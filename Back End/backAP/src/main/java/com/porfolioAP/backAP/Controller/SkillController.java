package com.porfolioAP.backAP.Controller;

import com.porfolioAP.backAP.Entity.Skill;
import com.porfolioAP.backAP.Interface.SkillIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost4200")
public class SkillController {
    @Autowired SkillIService skillIService;

    @GetMapping("/skill/get")
    public List<Skill> getSkill(){
        return skillIService.getSkill();
    }

    @PostMapping("/skill/create")
    public String createSkill(@RequestBody Skill skill){
        skillIService.saveSkill(skill);
        return "La skill ha sido creada exitósamente.";
    }

    @DeleteMapping("/skill/delete/{id}")
    public String deleteSkill(@PathVariable Long id){
        skillIService.deleteSkill(id);
        return "El skill ha sido eliminada exitósamente.";
    }

    @PutMapping("/skill/edit/{id}")
    public Skill editSkill(@PathVariable Long id,
                           @RequestParam("sk_nombre") String newSkNombre,
                           @RequestParam("sk_nivel") Integer newSkNivel){
        Skill skill = skillIService.findSkill(id);

        skill.setSk_nombre(newSkNombre);
        skill.setSk_nivel(newSkNivel);

        skillIService.saveSkill(skill);
        return skill;
    }

    //@GetMapping("/skill/get/skills")
    //public Skill findSkill(){
    //   return skillIService.findSkill((long)id);
    //}
}
