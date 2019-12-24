package com.example.testFCagain.repository;

import com.example.testFCagain.model.entity.AdminUser;
import com.example.testFCagain.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {
}
