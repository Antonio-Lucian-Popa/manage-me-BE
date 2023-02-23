package com.asusoftware.manageme.invitationLink.controller;

import com.asusoftware.manageme.company.model.CreateCompanyDto;
import com.asusoftware.manageme.invitationLink.model.CreateInvitationLinkDto;
import com.asusoftware.manageme.invitationLink.service.InvitationLinkService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/invitation-links")
public class InvitationLinkController {

    private final InvitationLinkService invitationLinkService;

    @PostMapping(path = "/createInvitationLink/{companyId}")
    public UUID create(@PathVariable(name = "companyId") UUID companyId, @RequestBody CreateInvitationLinkDto createInvitationLinkDto) {
        return invitationLinkService.create(companyId, createInvitationLinkDto);
    }

    // TODO: Trebuie creat entitatea USer Roles pentru ca nu putem salva o lista intro entitate
}
