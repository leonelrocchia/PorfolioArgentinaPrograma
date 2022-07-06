package com.porfolioAP.backAP.Controller;

import com.porfolioAP.backAP.Entity.Project;
import com.porfolioAP.backAP.Interface.ProjectIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectController {
    @Autowired ProjectIService projectIService;

    @GetMapping("/project/get")
    public List<Project> getProject(){
        return projectIService.getProject();
    }

    @PostMapping("/project/create")
    public String createProject(@RequestBody Project project){
        projectIService.saveProject(project);
        return "El componente de proyecto ha sido creado exitósamente.";
    }

    @DeleteMapping("/project/delete/{id}")
    public String deleteProject(@PathVariable Long id){
        projectIService.deleteProject(id);
        return "El componente de proyecto ha eliminado exitósamente.";
    }

    @PutMapping("/project/edit/{id}")
    public Project editProject(@PathVariable Long id,
                                     @RequestParam("pr_nombre") String newPrNombre,
                                     @RequestParam("pr_cliente") String newPrCliente,
                                     @RequestParam("pr_tipo") String newPrTipo,
                                     @RequestParam("pr_descripcion") String newPrDescripcion,
                                     @RequestParam("pr_img") String newPrImg,
                                     @RequestParam("pr_fecha") String newPrFecha,
                                     @RequestParam("pr_link") String newPrLink){
        Project project = projectIService.findProject(id);

        project.setPr_nombre(newPrNombre);
        project.setPr_cliente(newPrCliente);
        project.setPr_tipo(newPrTipo);
        project.setPr_descripcion(newPrDescripcion);
        project.setPr_img(newPrImg);
        project.setPr_fecha(newPrFecha);
        project.setPr_link(newPrLink);

        projectIService.saveProject(project);
        return project;
    }

    //@GetMapping("/project/get/projects")
    //public Project findProject(){
    //   return projectIService.findProject((long)id);
    //}
}
