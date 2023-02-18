package com.asusoftware.manageme.company.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/companies")
public class CompanyController {

    @PostMapping(path = "/createCompany")
    public void create() {}
}


// Cum merge:
/*
* Mai intai se creaza compania de transport, dupa care compania de transport va crea un link de invitatie
* pentru angajati ca ei sa se poata inregistra, ar fii bine de integrat posibilitatea ca prin link sa se
* inteleaga ce rol are acea persoana si sa se creeze automat cu acea persoana acel rol atribuit ei
* */