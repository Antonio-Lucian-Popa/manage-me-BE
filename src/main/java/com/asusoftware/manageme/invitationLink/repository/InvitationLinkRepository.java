package com.asusoftware.manageme.invitationLink.repository;

import com.asusoftware.manageme.invitationLink.model.InvitationLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InvitationLinkRepository extends JpaRepository<InvitationLink, UUID> {
}
