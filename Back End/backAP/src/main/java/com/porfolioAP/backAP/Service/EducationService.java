package com.porfolioAP.backAP.Service;

import com.porfolioAP.backAP.Entity.Education;
import com.porfolioAP.backAP.Interface.EducationIService;
import com.porfolioAP.backAP.Repository.EducationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService implements EducationIService {
    @Autowired
    EducationRepo educationRepo;

    @Override
    public List<Education> getEducation() {
        List<Education> education = educationRepo.findAll();
        return education;
    }

    @Override
    public void saveEducation(Education education) {
        educationRepo.save(education);
    }

    @Override
    public void deleteEducation(Long id) {
        educationRepo.deleteById(id);
    }

    @Override
    public Education findEducation(Long id) {
        Education education = educationRepo.findById(id).orElse(null);
        return education;
    }
}
