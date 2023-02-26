package com.asusoftware.manageme.user.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity(name = "UserRole")
@Table(name = "user_roles")
public class UserRole {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "role", nullable = false)
    private String role;
}
