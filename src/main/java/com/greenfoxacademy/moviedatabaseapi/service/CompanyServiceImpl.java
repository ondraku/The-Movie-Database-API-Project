package com.greenfoxacademy.moviedatabaseapi.service;

import com.greenfoxacademy.moviedatabaseapi.entity.Company;
import com.greenfoxacademy.moviedatabaseapi.model.CompanyDTO;
import com.greenfoxacademy.moviedatabaseapi.repository.CompanyRepository;
import com.greenfoxacademy.moviedatabaseapi.service.mapper.CompanyMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompanyServiceImpl implements CompanyService {

    private static final String CompanyURL = "https://api.themoviedb.org/3/company/";

    private final CompanyRepository companyRepository;
    private final RestTemplate restTemplate;
    private final CompanyMapper companyMapper;


    public CompanyServiceImpl(CompanyRepository companyRepository, RestTemplate restTemplate, CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.restTemplate = restTemplate;
        this.companyMapper = companyMapper;
    }

    @Override
    public CompanyDTO getCompanies(Long id, String apiKey) {
        CompanyDTO companyDto = restTemplate.getForObject(CompanyURL + id + "?api_key=" + apiKey, CompanyDTO.class);

        Company companyEntity = companyMapper.DTOtoEntity(companyDto);
        addCompany(companyEntity);

        return companyDto;
    }

    @Override
    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

}
