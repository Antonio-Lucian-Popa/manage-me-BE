package com.asusoftware.manageme.invitationLink.service;

import com.asusoftware.manageme.company.model.Company;
import com.asusoftware.manageme.company.model.CreateCompanyDto;
import com.asusoftware.manageme.company.repository.CompanyRepository;
import com.asusoftware.manageme.company.service.CompanyService;
import com.asusoftware.manageme.exceptions.CompanyNotFoundException;
import com.asusoftware.manageme.exceptions.InvitationLinkNotFoundException;
import com.asusoftware.manageme.invitationLink.model.CreateInvitationLinkDto;
import com.asusoftware.manageme.invitationLink.model.InvitationLink;
import com.asusoftware.manageme.invitationLink.repository.InvitationLinkRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Service
@AllArgsConstructor
public class InvitationLinkService {

    private final InvitationLinkRepository invitationLinkRepository;
    private final CompanyRepository companyRepository;

    public UUID create(UUID companyId, CreateInvitationLinkDto createInvitationLinkDto) {
        Company company = companyRepository.findById(companyId).orElseThrow(() -> new CompanyNotFoundException("Company not found!"));
        InvitationLink invitationLink = new InvitationLink();
        invitationLink.setValue(UUID.randomUUID().toString());
        invitationLink.setCreatedAt(LocalDateTime.now(ZoneOffset.UTC));
        invitationLink.setCompany(company);
        invitationLink.setUserRoles(createInvitationLinkDto.getUserRoles());
        invitationLinkRepository.save(invitationLink);
        return invitationLink.getId();
    }

    public InvitationLink findById(UUID invitationLinkId) {
        return invitationLinkRepository.findById(invitationLinkId).orElseThrow(() -> new InvitationLinkNotFoundException("Invitation link not found!"));
    }

    public void deleteById(UUID invitationLinkId) {
        invitationLinkRepository.deleteById(invitationLinkId);
    }
}
