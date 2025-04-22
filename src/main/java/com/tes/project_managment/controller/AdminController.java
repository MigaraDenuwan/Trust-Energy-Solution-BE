// AdminController.java
package com.tes.project_managment.controller;

import com.tes.project_managment.model.Admin;
import com.tes.project_managment.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @Autowired
    private AdminRepository adminRepo;

    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminRepo.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable String id) {
        adminRepo.deleteById(id);
    }
}
