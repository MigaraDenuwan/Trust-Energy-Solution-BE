package com.tes.project_managment.repository;

import com.tes.project_managment.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository extends MongoRepository<Project, String> {
}
