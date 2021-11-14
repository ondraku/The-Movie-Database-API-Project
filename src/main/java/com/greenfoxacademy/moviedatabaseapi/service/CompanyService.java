package com.greenfoxacademy.moviedatabaseapi.service;


import com.greenfoxacademy.moviedatabaseapi.model.Company;
import com.greenfoxacademy.moviedatabaseapi.model.dto.CompanyDto;
import org.springframework.stereotype.Service;

@Service
public interface CompanyService {
    CompanyDto getCompanies(Long id, String apiKey);

    CompanyDto mapToDto(Company company);

    Company mapToEntity(CompanyDto companyDto);
}
