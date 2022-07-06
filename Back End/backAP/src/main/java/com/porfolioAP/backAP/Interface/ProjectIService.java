package com.porfolioAP.backAP.Interface;

import com.porfolioAP.backAP.Entity.Project;

import java.util.List;

public interface ProjectIService {

    public List<Project> getProject();

    public void saveProject(Project project);

    public void deleteProject(Long id);

    public Project findProject(Long id);
}
