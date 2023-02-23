package com.asusoftware.manageme.company.model;

import com.asusoftware.manageme.invitationLink.model.InvitationLink;
import com.asusoftware.manageme.user.model.Ceo;
import com.asusoftware.manageme.user.model.Employee;
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

    @OneToMany(mappedBy="company", cascade = CascadeType.ALL)
    private List<Ceo> ceoList;

    @OneToMany(mappedBy="company", cascade = CascadeType.ALL)
    private List<Employee> employees;

    @OneToMany(mappedBy="company", cascade = CascadeType.ALL)
    private List<InvitationLink> invitationLinks;
}
