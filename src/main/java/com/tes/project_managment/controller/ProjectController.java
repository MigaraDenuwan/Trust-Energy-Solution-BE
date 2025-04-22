package com.tes.project_managment.controller;

import com.tes.project_managment.model.Project;
import com.tes.project_managment.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/ProjectController/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectServiceDetails;

    @PostMapping
    public Project createProject(@RequestBody Project projectDetails) {
        return projectServiceDetails.createProject(projectDetails);
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectServiceDetails.getAllProjects();
    }

    @PutMapping("/{id}")
    public Project updateProjects(@PathVariable String id, @RequestBody Project projectDetails) {
        return projectServiceDetails.updateProjects(id, projectDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable String id) {
        projectServiceDetails.deleteProject(id);
    }

    @PostMapping("/upload")
    public Project createProjectWithImage(
            @RequestPart("project") Project project,
            @RequestPart("image")MultipartFile file) throws IOException{

        String image = Base64.getEncoder().encodeToString(file.getBytes());
        project.setImage(image);

        return projectServiceDetails.createProject(project);
    }

    @PutMapping("/upload/{id}")
    public Project updateProjectWithImage(
            @PathVariable String id,
            @RequestPart("project") Project project,
            @RequestPart(value = "image", required = false) MultipartFile file) throws IOException{

        if(file != null && !file.isEmpty()){
            String image = Base64.getEncoder().encodeToString(file.getBytes());
            project.setImage(image);
        }
        return projectServiceDetails.updateProjects(id, project);
    }
}
