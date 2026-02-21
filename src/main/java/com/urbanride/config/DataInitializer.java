package com.urbanride.config;

import com.urbanride.model.User;
import com.urbanride.model.UserRole;
import com.urbanride.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        // Create a default admin user if one doesn't exist
        String adminUsername = System.getenv().getOrDefault("ADMIN_USERNAME", "admin");
        String adminPassword = System.getenv().getOrDefault("ADMIN_PASSWORD", "password");
        String adminEmail = System.getenv().getOrDefault("ADMIN_EMAIL", "admin@rideshare.com");
        if (userService.findByUsername(adminUsername).isEmpty()) {
            User admin = new User();
            admin.setUsername(adminUsername);
            admin.setFirstName("Admin");
            admin.setLastName("User");
            admin.setEmail(adminEmail);
            admin.setPassword(adminPassword); // Will be encoded by the service
            admin.setRole(UserRole.ADMIN);
            userService.createUser(admin, UserRole.ADMIN);
            System.out.println("Created default admin user.");
        }
    }
} 