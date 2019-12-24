package com.example.testFCagain.repository;

import com.example.testFCagain.model.entity.Category;
import com.example.testFCagain.model.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerRepository extends JpaRepository<Partner, Long> {
}
