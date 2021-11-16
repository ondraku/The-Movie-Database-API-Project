package com.greenfoxacademy.moviedatabaseapi.service;


import com.greenfoxacademy.moviedatabaseapi.entity.Company;
import com.greenfoxacademy.moviedatabaseapi.model.CompanyDTO;
import org.springframework.stereotype.Service;

@Service
public interface CompanyService {
    CompanyDTO getCompanies(Long id, String apiKey);
    Company addCompany(Company company);
}
