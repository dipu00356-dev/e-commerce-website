package com.eazydeals.test;

import com.eazydeals.dao.AdminDao;
import com.eazydeals.entities.Admin;
import com.eazydeals.helper.ConnectionProvider;

public class AdminLoginTest {
    
    public static void main(String[] args) {
        System.out.println("Testing Admin Login...");
        
        // Test the database connection
        if (ConnectionProvider.getConnection() != null) {
            System.out.println("✓ Database connection successful");
        } else {
            System.out.println("✗ Database connection failed");
            return;
        }
        
        // Test admin authentication with known credentials
        AdminDao adminDao = new AdminDao(ConnectionProvider.getConnection());
        
        // Test with first admin
        String email1 = "test@gmail.com";
        String password1 = "abc123";
        System.out.println("\nTesting with: " + email1 + " / " + password1);
        Admin admin1 = adminDao.getAdminByEmailPassword(email1, password1);
        if (admin1 != null) {
            System.out.println("✓ Admin login successful: " + admin1.getName());
        } else {
            System.out.println("✗ Admin login failed");
        }
        
        // Test with second admin
        String email2 = "test34@gmail.com";
        String password2 = "abc";
        System.out.println("\nTesting with: " + email2 + " / " + password2);
        Admin admin2 = adminDao.getAdminByEmailPassword(email2, password2);
        if (admin2 != null) {
            System.out.println("✓ Admin login successful: " + admin2.getName());
        } else {
            System.out.println("✗ Admin login failed");
        }
        
        // Test with new admin (if created)
        String email3 = "admin@eazydeals.com";
        String password3 = "admin123";
        System.out.println("\nTesting with: " + email3 + " / " + password3);
        Admin admin3 = adminDao.getAdminByEmailPassword(email3, password3);
        if (admin3 != null) {
            System.out.println("✓ Admin login successful: " + admin3.getName());
        } else {
            System.out.println("✗ Admin login failed");
        }
        
        // List all admins
        System.out.println("\nAll admins in database:");
        try {
            adminDao.getAllAdmin().forEach(admin -> {
                System.out.println("- ID: " + admin.getId() + ", Name: " + admin.getName() + 
                                 ", Email: " + admin.getEmail() + ", Password: " + admin.getPassword());
            });
        } catch (Exception e) {
            System.out.println("Error fetching admin list: " + e.getMessage());
        }
    }
}