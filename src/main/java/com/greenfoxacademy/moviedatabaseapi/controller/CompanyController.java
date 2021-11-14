package com.greenfoxacademy.moviedatabaseapi.controller;

import com.greenfoxacademy.moviedatabaseapi.model.CompanyDTO;
import com.greenfoxacademy.moviedatabaseapi.service.CompanyService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CompanyController {

    @Value("${api.key}")
    private String apiKey;

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/company/{companyId}")
    public CompanyDTO getCompanies(@PathVariable Long companyId) {
        return companyService.getCompanies(companyId, apiKey);
    }
}
