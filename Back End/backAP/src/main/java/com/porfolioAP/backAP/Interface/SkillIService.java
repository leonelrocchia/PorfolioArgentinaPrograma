package com.porfolioAP.backAP.Interface;

import com.porfolioAP.backAP.Entity.Skill;

import java.util.List;

public interface SkillIService {

    public List<Skill> getSkill();

    public void saveSkill(Skill skill);

    public void deleteSkill(Long id);

    public Skill findSkill(Long id);
}
