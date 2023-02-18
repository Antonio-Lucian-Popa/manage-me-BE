package com.asusoftware.manageme.company.model;

import com.asusoftware.manageme.user.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "Company")
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "employees", nullable = false)
    @OneToMany(mappedBy = "company")
    private List<User> employees;


    // TODO: De gandit cum sa asociem linkul de invitatie pentru user cu rolul deja setat
}
