package com.tes.project_managment;

import com.tes.project_managment.model.Admin;
import com.tes.project_managment.repository.AdminRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ProjectManagmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagmentApplication.class, args);
	}

	@Bean
	CommandLineRunner initAdmin(AdminRepository adminRepo, PasswordEncoder encoder) {
		return args -> {
			if (adminRepo.findByUsername("admin").isEmpty()) {
				Admin admin = new Admin();
				admin.setUsername("admin");
				admin.setPassword(encoder.encode("admin123"));
				admin.setSuperAdmin(true);
				adminRepo.save(admin);
				System.out.println("Super admin created: admin/admin123");
			}
		};
	}
}
