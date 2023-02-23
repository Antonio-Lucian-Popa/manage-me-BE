package com.asusoftware.manageme.mappers;

import com.asusoftware.manageme.user.model.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDtoEntity {


    EmployeeDto employeeToDto(Employee employee);

    CeoDto ceoToDto(Ceo ceo);

    Employee employeeToEntity(CreateUserDto createUserDto);

    Ceo ceoToEntity(CreateUserDto createUserDto);

}