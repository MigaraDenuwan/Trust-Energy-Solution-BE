package com.tes.project_managment.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collation = "admins")
public class Admin {
    @Id
    private String id;
    private String username;
    private String password;
    private boolean isSuperAdmin = false;
}
