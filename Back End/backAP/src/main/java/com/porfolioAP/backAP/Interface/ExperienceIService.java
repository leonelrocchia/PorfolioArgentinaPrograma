package com.porfolioAP.backAP.Interface;


import com.porfolioAP.backAP.Entity.Experience;


import java.util.List;

public interface ExperienceIService {

    public List<Experience> getExperience();

    public void saveExperience(Experience experience);

    public void deleteExperience(Long id);

    public Experience findExperience(Long id);
}
