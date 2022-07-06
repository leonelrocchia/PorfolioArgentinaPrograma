package com.porfolioAP.backAP.Service;

import com.porfolioAP.backAP.Entity.Project;
import com.porfolioAP.backAP.Interface.ProjectIService;
import com.porfolioAP.backAP.Repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService implements ProjectIService {
    @Autowired
    ProjectRepo projectRepo;

    @Override
    public List<Project> getProject() {
        List<Project> project = projectRepo.findAll();
        return project;
    }

    @Override
    public void saveProject(Project project) {
        projectRepo.save(project);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepo.deleteById(id);
    }

    @Override
    public Project findProject(Long id) {
        Project project = projectRepo.findById(id).orElse(null);
        return project;
    }
}
