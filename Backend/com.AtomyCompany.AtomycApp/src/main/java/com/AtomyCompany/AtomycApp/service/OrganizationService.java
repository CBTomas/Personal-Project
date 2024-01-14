package com.AtomyCompany.AtomycApp.service;

import com.AtomyCompany.AtomycApp.DTO.OrganizationDTO;
import jakarta.transaction.Transactional;

@Transactional
public interface OrganizationService{

    OrganizationDTO saveOrganization(OrganizationDTO organizationDTO);

    OrganizationDTO getOrganizationById(String name);

    void deleteOrganization(String name);


}
