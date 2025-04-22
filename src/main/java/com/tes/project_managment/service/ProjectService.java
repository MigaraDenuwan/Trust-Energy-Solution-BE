package com.tes.project_managment.service;

import com.tes.project_managment.model.Project;

import java.util.List;

public interface ProjectService {
    Project createProject(Project projectDetails);
    List<Project> getAllProjects();
    Project updateProjects(String id, Project projectDetails);
    void deleteProject(String id);
    Project getProjectByID(String id);
}
