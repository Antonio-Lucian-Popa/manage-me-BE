package com.asusoftware.manageme.company.model;

import com.asusoftware.manageme.user.model.CeoDto;
import com.asusoftware.manageme.user.model.EmployeeDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CompanyDto {
    private UUID id;
    private String name;
    private List<CeoDto> ceoList;
    private List<EmployeeDto> employees;
}
