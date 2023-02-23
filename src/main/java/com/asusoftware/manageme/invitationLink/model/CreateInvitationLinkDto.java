package com.asusoftware.manageme.invitationLink.model;

import com.asusoftware.manageme.user.model.UserRole;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateInvitationLinkDto {
    private List<UserRole> userRoles;
}
