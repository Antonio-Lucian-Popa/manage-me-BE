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
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy="company")
    private List<User> ceoList;

    @OneToMany(mappedBy="company")
    private List<User> employees;
}
