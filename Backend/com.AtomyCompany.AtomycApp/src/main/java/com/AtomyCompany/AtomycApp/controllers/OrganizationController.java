package com.AtomyCompany.AtomycApp.controllers;

import com.AtomyCompany.AtomycApp.Application;
import com.AtomyCompany.AtomycApp.DTO.OrganizationDTO;
import com.AtomyCompany.AtomycApp.service.OrganizationService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrganizationController {

    private static final Logger myLog= LoggerFactory.getLogger(Application.class);

    @Autowired
    private HttpServletRequest context;

    @Autowired
    private OrganizationService organizationService;

    @GetMapping("atomycapp/organization/{idOrganization}")
    public ResponseEntity<OrganizationDTO> showOrganizationById(@PathVariable String idOrganization){
        myLog.info(context.getMethod() + context.getRequestURI() + " from " + context.getRemoteHost());
        OrganizationDTO organizationDTO =organizationService.getOrganizationById(idOrganization);
        if (organizationDTO==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(organizationDTO,HttpStatus.OK);
        }
    }

    @PostMapping("atomycapp/organization")
    public ResponseEntity<OrganizationDTO> addOrganitation(@RequestBody OrganizationDTO organizationDTO){
        myLog.info(context.getMethod() + context.getRequestURI());

        OrganizationDTO organizationSaved = organizationService.saveOrganization(organizationDTO);
        if (organizationSaved==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(organizationSaved,HttpStatus.OK);
        }
    }


    @PutMapping("atomycapp/organization")
    public ResponseEntity<OrganizationDTO> updateOrganization(@RequestBody OrganizationDTO updOrganization){
        myLog.info(context.getMethod() + context.getRequestURI());
        OrganizationDTO organizationDTO = organizationService.getOrganizationById(updOrganization.getName());
        if(organizationDTO==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            OrganizationDTO organizationUPD = organizationService.saveOrganization(updOrganization);
            return new ResponseEntity<>(organizationUPD,HttpStatus.OK);
        }
    }

    public ResponseEntity<String> deleteOrganization(@PathVariable String name){
        organizationService.deleteOrganization(name);
        return new ResponseEntity<>("The organization has been eliminated", HttpStatus.OK);
    }

}
