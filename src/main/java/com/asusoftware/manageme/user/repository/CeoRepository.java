package com.asusoftware.manageme.user.repository;

import com.asusoftware.manageme.user.model.Ceo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CeoRepository extends JpaRepository<Ceo, UUID> {
}
