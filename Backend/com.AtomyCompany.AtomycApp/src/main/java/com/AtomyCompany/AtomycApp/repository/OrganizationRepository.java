package com.AtomyCompany.AtomycApp.repository;

import com.AtomyCompany.AtomycApp.model.Organization;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface OrganizationRepository extends JpaRepository<Organization, String> {
}
