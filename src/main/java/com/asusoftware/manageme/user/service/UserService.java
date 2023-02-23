package com.asusoftware.manageme.user.service;

import com.asusoftware.manageme.company.model.Company;
import com.asusoftware.manageme.company.service.CompanyService;
import com.asusoftware.manageme.exceptions.UserNotFoundException;
import com.asusoftware.manageme.invitationLink.model.InvitationLink;
import com.asusoftware.manageme.invitationLink.service.InvitationLinkService;
import com.asusoftware.manageme.mappers.UserDtoEntity;
import com.asusoftware.manageme.user.model.*;
import com.asusoftware.manageme.user.repository.CeoRepository;
import com.asusoftware.manageme.user.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private final CeoRepository ceoRepository;
    private final EmployeeRepository employeeRepository;
    private final UserDtoEntity userDtoEntity;
    private final InvitationLinkService invitationLinkService;

    public void createCeo(CreateUserDto createUserDto) {
        ceoRepository.save(userDtoEntity.ceoToEntity(createUserDto));
    }

    public void createEmployee(UUID invitationLinkId, CreateUserDto createUserDto) {
        // Call invitation link repository and find the invitation link
        InvitationLink invitationLink = invitationLinkService.findById(invitationLinkId);
        // Get info from invitation link entity and set it on employee
        Employee employee = userDtoEntity.employeeToEntity(createUserDto);
        employee.setUserRoles(invitationLink.getUserRoles());
        employee.setCompany(invitationLink.getCompany());
        // save employee on company id from invitation link
        employeeRepository.save(employee);
        // Delete invitation link after employee is created
        invitationLinkService.deleteById(invitationLinkId);
    }

    public Ceo findCeoById(UUID id) {
       return ceoRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Ceo not found!"));
    }

    public Employee findEmployeeById(UUID id) {
        return employeeRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Employee not found!"));
    }

    // Aici pot arata toti useri cu proprietati predefinite
    public List<CeoDto> findAllCeo() {
        return ceoRepository.findAll().stream().map(userDtoEntity::ceoToDto).collect(Collectors.toList());
    }

    public List<EmployeeDto> findAllEmployee() {
        return employeeRepository.findAll().stream().map(userDtoEntity::employeeToDto).collect(Collectors.toList());
    }

}
