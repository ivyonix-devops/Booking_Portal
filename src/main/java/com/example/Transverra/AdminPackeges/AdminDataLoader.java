package com.example.Transverra.AdminPackeges;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AdminDataLoader implements CommandLineRunner {

    @Autowired private AdminRepository adminRepository;
    @Override
    public void run(String... args) throws Exception {

        // Check if admin already exists
        if (adminRepository.count() == 0) {
            AdminModel adminModel = new AdminModel();
            adminModel.setAdmName("admin");
            adminModel.setAdm_mail("admin@gmail.com");
            adminModel.setAdm_password("Admin@123");
            adminRepository.save(adminModel);

            System.out.println("Default admin created");
        } else {
            System.out.println("Admin already exists — skipping creation");
        }
    }
    }


