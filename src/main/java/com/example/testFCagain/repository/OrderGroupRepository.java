package com.example.testFCagain.repository;

import com.example.testFCagain.model.entity.Category;
import com.example.testFCagain.model.entity.OrderGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderGroupRepository extends JpaRepository<OrderGroup, Long> {
}
