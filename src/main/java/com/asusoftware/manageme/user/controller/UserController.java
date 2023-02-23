package com.asusoftware.manageme.user.controller;

import com.asusoftware.manageme.user.model.CeoDto;
import com.asusoftware.manageme.user.model.CreateUserDto;
import com.asusoftware.manageme.user.model.EmployeeDto;
import com.asusoftware.manageme.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/create-ceo")
    public void createCeo(@RequestBody CreateUserDto createUserDto) {
        userService.createCeo(createUserDto);
    }

    @PostMapping("/create-employee/{invitationLink}")
    public void createEmployee(@PathVariable(name = "invitationLink") UUID invitationLinkId, @RequestBody CreateUserDto createUserDto) {
        userService.createEmployee(invitationLinkId, createUserDto);
    }

    // TODO: find ceo by company id
    @GetMapping("/findAllCeo")
    public List<CeoDto> findAllCeo() {
        return userService.findAllCeo();
    }

    // TODO: find employees by company id
    @GetMapping("/findAllEmployee")
    public List<EmployeeDto> findAllEmployee() {
        return userService.findAllEmployee();
    }
}
