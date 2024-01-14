package com.AtomyCompany.AtomycApp.service;

import com.AtomyCompany.AtomycApp.DTO.OrganizationDTO;
import com.AtomyCompany.AtomycApp.model.Organization;
import com.AtomyCompany.AtomycApp.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrganizationServiceImpl implements OrganizationService{

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDTO saveOrganization(OrganizationDTO organizationDTO) {

        Organization organization = OrganizationDTO.convertToEntity(organizationDTO);

        Organization organizationSaved = organizationRepository.save(organization);

        return OrganizationDTO.convertToDTO(organizationSaved);
    }

    @Override
    public OrganizationDTO getOrganizationById(String name) {

        Optional<Organization> organization = organizationRepository.findById(name);

        return organization.map(OrganizationDTO::convertToDTO).orElse(null);

    }

    @Override
    public void deleteOrganization(String name) {
        organizationRepository.deleteById(name);
    }
}
