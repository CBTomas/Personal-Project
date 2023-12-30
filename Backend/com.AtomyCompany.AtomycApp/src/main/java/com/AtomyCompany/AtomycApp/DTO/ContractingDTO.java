package com.AtomyCompany.AtomycApp.DTO;

import com.AtomyCompany.AtomycApp.model.Contracting;
import com.AtomyCompany.AtomycApp.model.Event;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
public class ContractingDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 4L;

    private Long idContracting;
    private String contractingName;
    private String description;
    private int price;
    private Date registContracting;

    @ToString.Exclude
    @JsonIgnore
    private EventDTO eventContracting;

    public static ContractingDTO convertToDTO(Contracting contracting, EventDTO eventDTO){

        ContractingDTO contractingDTO = new ContractingDTO();

        contractingDTO.setIdContracting(contractingDTO.getIdContracting());
        contractingDTO.setContractingName(contractingDTO.getContractingName());
        contractingDTO.setDescription(contractingDTO.getDescription());
        contractingDTO.setPrice(contractingDTO.getPrice());
        contractingDTO.setRegistContracting(contracting.getRegistContracting());

        if (eventDTO != null){
            contractingDTO.setEventContracting(eventDTO);
        }else{
            if (contracting.getEventContracting() != null){
                contractingDTO.setEventContracting(EventDTO.convertToDTO(contracting.getEventContracting(), null));
            }
        }

        return contractingDTO;
    }

    public static Contracting convertToEntity(ContractingDTO contractingDTO){

        Contracting contracting = new Contracting();

        contracting.setIdContracting(contractingDTO.getIdContracting());
        contracting.setContractingName(contractingDTO.getContractingName());
        contracting.setDescription(contractingDTO.getDescription());
        contracting.setPrice(contractingDTO.getPrice());
        contracting.setRegistContracting(contractingDTO.getRegistContracting());

        if (contractingDTO.getEventContracting() != null){
            contracting.setEventContracting(EventDTO.convertToEntity(contractingDTO.getEventContracting()));
        }

        return contracting;
    }
}