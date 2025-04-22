package com.tes.project_managment.controller;

import com.tes.project_managment.model.Admin;
import com.tes.project_managment.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AdminRepository adminRepo;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/register")
    public Admin register(@RequestBody Admin admin) {
        admin.setPassword(encoder.encode(admin.getPassword()));
        return adminRepo.save(admin);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login() {
        return ResponseEntity.ok("Login successful");
    }
}
