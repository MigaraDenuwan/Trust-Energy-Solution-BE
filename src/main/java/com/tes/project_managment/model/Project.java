package com.tes.project_managment.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collation = "projects")
public class Project {
    @Id
    private String id;
    private String title;
    private String image;
    private String description;
}
