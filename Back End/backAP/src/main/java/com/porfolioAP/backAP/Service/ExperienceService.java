package com.porfolioAP.backAP.Service;

import com.porfolioAP.backAP.Entity.Experience;
import com.porfolioAP.backAP.Interface.ExperienceIService;
import com.porfolioAP.backAP.Repository.ExperienceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService implements ExperienceIService {
    @Autowired
    ExperienceRepo experienceRepo;

    @Override
    public List<Experience> getExperience() {
        List<Experience> experience = experienceRepo.findAll();
        return experience;
    }

    @Override
    public void saveExperience(Experience experience) {
        experienceRepo.save(experience);
    }

    @Override
    public void deleteExperience(Long id) {
        experienceRepo.deleteById(id);
    }

    @Override
    public Experience findExperience(Long id) {
        Experience experience = experienceRepo.findById(id).orElse(null);
        return experience;
    }
}
