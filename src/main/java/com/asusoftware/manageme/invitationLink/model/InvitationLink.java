package com.asusoftware.manageme.invitationLink.model;

import com.asusoftware.manageme.company.model.Company;
import com.asusoftware.manageme.user.model.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "InvitationLink")
@Table(name = "invitationLinks")
public class InvitationLink {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "value", nullable = false)
    private String value;

    @Column(name = "user_roles", nullable = false)
    @ElementCollection(targetClass = UserRole.class)
    @Enumerated(EnumType.STRING)
    private List<UserRole> userRoles;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name="company_id", nullable=false)
    private Company company;

}
