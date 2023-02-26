package com.asusoftware.manageme.user.model;

import com.asusoftware.manageme.company.model.Company;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "Employee")
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Email
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "birthday", nullable = true)
    private LocalDate birthday;

    @Column(name = "status", nullable = true)
    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;

    @ManyToOne
    @JoinColumn(name="company_id", nullable=true)
    private Company company;

    @OneToMany(mappedBy="employee", cascade = {CascadeType.PERSIST, CascadeType.DETACH})
    private List<UserRole> userRoles;
}
