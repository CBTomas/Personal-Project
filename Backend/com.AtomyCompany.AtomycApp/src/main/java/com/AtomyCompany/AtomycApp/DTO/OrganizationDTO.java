package com.AtomyCompany.AtomycApp.DTO;

import com.AtomyCompany.AtomycApp.model.Organization;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

@Data
public class OrganizationDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 4L;

    private String name;
    private String address;
    private String city;
    private int members;

    public static OrganizationDTO convertToDTO(Organization organization){

        OrganizationDTO organizationDTO = new OrganizationDTO();

        organizationDTO.setName(organization.getName());
        organizationDTO.setAddress(organization.getAddress());
        organizationDTO.setCity(organization.getCity());
        organizationDTO.setMembers(organization.getMembers());

        return organizationDTO;
    }

    public static Organization convertToEntity(OrganizationDTO organizationDTO){

        Organization organization = new Organization();

        organization.setName(organizationDTO.getName());
        organization.setAddress(organizationDTO.getAddress());
        organization.setCity(organizationDTO.getCity());
        organization.setMembers(organizationDTO.getMembers());

        return organization;
    }


}
