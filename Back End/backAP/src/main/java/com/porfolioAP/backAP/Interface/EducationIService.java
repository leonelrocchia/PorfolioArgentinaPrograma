package com.porfolioAP.backAP.Interface;


import com.porfolioAP.backAP.Entity.Education;


import java.util.List;

public interface EducationIService {

    public List<Education> getEducation();

    public void saveEducation(Education education);

    public void deleteEducation(Long id);

    public Education findEducation(Long id);
}
