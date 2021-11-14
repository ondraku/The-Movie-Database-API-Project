package com.greenfoxacademy.moviedatabaseapi.service;

import com.greenfoxacademy.moviedatabaseapi.entity.Company;
import com.greenfoxacademy.moviedatabaseapi.model.CompanyDTO;
import com.greenfoxacademy.moviedatabaseapi.repository.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompanyServiceImpl implements CompanyService {

    private static final String CompanyURL = "https://api.themoviedb.org/3/company/";

    private final CompanyRepository companyRepository;
    private final RestTemplate restTemplate;
    private final ModelMapper modelMapper;


    public CompanyServiceImpl(CompanyRepository companyRepository, RestTemplate restTemplate, ModelMapper modelMapper) {
        this.companyRepository = companyRepository;
        this.restTemplate = restTemplate;
        this.modelMapper = modelMapper;
    }

    @Override
    public CompanyDTO getCompanies(Long id, String apiKey) {
        CompanyDTO companyDto = restTemplate.getForObject(CompanyURL + id + "?api_key=" + apiKey, CompanyDTO.class);
        Company companyEntity = mapToEntity(companyDto);

        addCompany(companyEntity);

        return companyDto;
    }

    @Override
    public CompanyDTO mapToDto(Company company) {
        return modelMapper.map(company, CompanyDTO.class);
    }

    @Override
    public Company mapToEntity(CompanyDTO companyDto) {
        return modelMapper.map(companyDto, Company.class);
    }

    @Override
    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }


}
