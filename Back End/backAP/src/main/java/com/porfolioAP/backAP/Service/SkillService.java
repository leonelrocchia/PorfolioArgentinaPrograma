package com.porfolioAP.backAP.Service;

import com.porfolioAP.backAP.Entity.Skill;
import com.porfolioAP.backAP.Interface.SkillIService;
import com.porfolioAP.backAP.Repository.SkillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService implements SkillIService {
    @Autowired
    SkillRepo skillRepo;

    @Override
    public List<Skill> getSkill() {
        List<Skill> skill = skillRepo.findAll();
        return skill;
    }

    @Override
    public void saveSkill(Skill skill) {
        skillRepo.save(skill);
    }

    @Override
    public void deleteSkill(Long id) {
        skillRepo.deleteById(id);
    }

    @Override
    public Skill findSkill(Long id) {
        Skill skill = skillRepo.findById(id).orElse(null);
        return skill;
    }
}
