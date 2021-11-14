package com.greenfoxacademy.moviedatabaseapi.service;

import com.greenfoxacademy.moviedatabaseapi.repository.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
}
