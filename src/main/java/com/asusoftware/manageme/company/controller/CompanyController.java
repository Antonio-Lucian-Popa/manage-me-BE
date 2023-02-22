package com.asusoftware.manageme.company.controller;

import com.asusoftware.manageme.company.model.CompanyDto;
import com.asusoftware.manageme.company.model.CreateCompanyDto;
import com.asusoftware.manageme.company.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/companies")
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping(path = "/createCompany/{ceoId}")
    public void create(@PathVariable(name = "ceoId") UUID ceoId, @RequestBody CreateCompanyDto createCompanyDto) {
        companyService.create(ceoId, createCompanyDto);
    }

    @GetMapping(path = "/findAll")
    public List<CompanyDto> findAll() {
        return companyService.findAll();
    }
}


// Cum merge:
/*
* Mai intai se creaza compania de transport, dupa care compania de transport va crea un link de invitatie
* pentru angajati ca ei sa se poata inregistra, ar fii bine de integrat posibilitatea ca prin link sa se
* inteleaga ce rol are acea persoana si sa se creeze automat cu acea persoana acel rol atribuit ei
* */