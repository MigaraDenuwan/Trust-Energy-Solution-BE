package com.tes.project_managment.service.impl;

import com.tes.project_managment.model.Project;
import com.tes.project_managment.repository.ProjectRepository;
import com.tes.project_managment.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepositoryData;

    @Override
    public Project createProject(Project projectDetails) {
        return projectRepositoryData.save(projectDetails);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepositoryData.findAll();
    }

    @Override
    public Project updateProjects(String id, Project projectDetails) {
        Project existing = getProjectByID(id);
        existing.setTitle(projectDetails.getTitle());
        existing.setDescription(projectDetails.getDescription());
        existing.setImage(projectDetails.getImage());
        return projectRepositoryData.save(existing);
    }

    @Override
    public void deleteProject(String id) {
        projectRepositoryData.deleteById(id);
    }

    @Override
    public Project getProjectByID(String id) {
        return projectRepositoryData.findById(id)
                .orElseThrow(()-> new RuntimeException("Project not found with id: " + id));
    }
}
