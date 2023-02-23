package com.asusoftware.manageme.company.service;

import com.asusoftware.manageme.company.model.Company;
import com.asusoftware.manageme.company.model.CompanyDto;
import com.asusoftware.manageme.company.model.CreateCompanyDto;
import com.asusoftware.manageme.company.repository.CompanyRepository;
import com.asusoftware.manageme.exceptions.CompanyNotFoundException;
import com.asusoftware.manageme.mappers.CompanyDtoEntity;
import com.asusoftware.manageme.user.model.Ceo;
import com.asusoftware.manageme.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final UserService userService;
    private final CompanyDtoEntity companyDtoEntity;

    /**
     * Create Company based on CEO uuid
     * @param ceoId the identifier for the ceo
     * @param createCompanyDto the company information
     */
    public void create(UUID ceoId, CreateCompanyDto createCompanyDto) {
        Company company = companyDtoEntity.companyToEntity(createCompanyDto);
        Ceo ceo = userService.findCeoById(ceoId);
        ceo.setCompany(company);
        List<Ceo> ceoList = new ArrayList<>();
        ceoList.add(ceo);
        company.setCeoList(ceoList);
        companyRepository.save(company);
    }

    public Company findById(UUID id) {
        return companyRepository.findById(id).orElseThrow(() -> new CompanyNotFoundException("Company not found!"));
    }

    public List<CompanyDto> findAll() {
        return companyRepository.findAll().stream().map(companyDtoEntity::companyToDto).collect(Collectors.toList());
    }

    /*

    private Company toEntity(CreateCompanyDto createCompanyDto) {
        Company company = new Company();
        company.setName(createCompanyDto.getName());
        return company;
    }


    private CompanyDto toDto(Company company) {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setId(company.getId());
        companyDto.setName(company.getName());
        companyDto.setCeoList(company.getCeoList().stream().map(this::toCeoDto).collect(Collectors.toList()));
        companyDto.setEmployees(company.getEmployees().stream().map(this::toEmployeeDto).collect(Collectors.toList()));
        return companyDto;
    }

    private CeoDto toCeoDto(User user) {
        CeoDto ceoDto = new CeoDto();
        ceoDto.setId(user.getId());
        ceoDto.setFirstName(user.getFirstName());
        ceoDto.setLastName(user.getLastName());
        ceoDto.setBirthday(user.getBirthday());
        ceoDto.setEmail(user.getEmail());
        ceoDto.setPhoneNumber(user.getPhoneNumber());
        ceoDto.setUserRoles(user.getUserRoles());
        return ceoDto;
    }

    private EmployeeDto toEmployeeDto(User user) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(user.getId());
        employeeDto.setFirstName(user.getFirstName());
        employeeDto.setLastName(user.getLastName());
        employeeDto.setBirthday(user.getBirthday());
        employeeDto.setEmail(user.getEmail());
        employeeDto.setPhoneNumber(user.getPhoneNumber());
        employeeDto.setUserRoles(user.getUserRoles());
        return employeeDto;
    } */
}
