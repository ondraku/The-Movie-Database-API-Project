package com.greenfoxacademy.moviedatabaseapi.service;

import com.greenfoxacademy.moviedatabaseapi.model.Company;
import com.greenfoxacademy.moviedatabaseapi.model.dto.CompanyDto;
import com.greenfoxacademy.moviedatabaseapi.repository.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
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
    public CompanyDto getCompanies(Long id, String apiKey) {
        ResponseEntity<CompanyDto> CompanyResponse = restTemplate
                .getForEntity(CompanyURL + id + "?api_key=" + apiKey, CompanyDto.class);

        //TODO: Mapper + Save to database
        return CompanyResponse.getBody();
    }

    @Override
    public CompanyDto mapToDto(Company company) {
        return modelMapper.map(company, CompanyDto.class);
    }

    @Override
    public Company mapToEntity(CompanyDto companyDto) {
        return modelMapper.map(companyDto, Company.class);
    }


}
