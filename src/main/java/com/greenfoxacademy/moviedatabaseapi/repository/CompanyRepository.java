package com.greenfoxacademy.moviedatabaseapi.repository;

import com.greenfoxacademy.moviedatabaseapi.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
