package com.asusoftware.manageme.mappers;

import com.asusoftware.manageme.company.model.Company;
import com.asusoftware.manageme.company.model.CompanyDto;
import com.asusoftware.manageme.company.model.CreateCompanyDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(uses = {UserDtoEntity.class}, componentModel = "spring")
public interface CompanyDtoEntity {

    @Mappings({
            @Mapping(source = "company.employees", target = "employees"),
            @Mapping(source = "company.ceoList", target = "ceoList"),
    })
    CompanyDto companyToDto(Company company);

    @Mappings({
            @Mapping(source = "companyDto.employees", target = "employees"),
            @Mapping(source = "companyDto.ceoList", target = "ceoList"),
    })
    Company companyToEntity(CompanyDto companyDto);


    Company companyToEntity(CreateCompanyDto createCompanyDto);
}
