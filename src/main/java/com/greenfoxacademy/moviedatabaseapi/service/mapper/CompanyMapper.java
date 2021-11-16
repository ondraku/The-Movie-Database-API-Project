package com.greenfoxacademy.moviedatabaseapi.service.mapper;

import com.greenfoxacademy.moviedatabaseapi.entity.Company;
import com.greenfoxacademy.moviedatabaseapi.model.CompanyDTO;
import org.mapstruct.Mapper;


@Mapper
public interface CompanyMapper {
    CompanyDTO entityToDTO(Company company);
    Company DTOtoEntity(CompanyDTO company);
}
