package com.greenfoxacademy.moviedatabaseapi.model.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDto {

    private Long id;
    private String description;
    private String headquarters;
    private String homepage;
    private String logo_path;
    private String name;
    private String origin_country;
    private Object parent_company; // TODO: Specific Object
}
