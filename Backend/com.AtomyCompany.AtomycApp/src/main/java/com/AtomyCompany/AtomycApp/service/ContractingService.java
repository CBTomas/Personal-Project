package com.AtomyCompany.AtomycApp.service;

import com.AtomyCompany.AtomycApp.DTO.ContractingDTO;
import jakarta.transaction.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
public interface ContractingService {

    ContractingDTO saveContracting(ContractingDTO contractingDTO);

    ContractingDTO getContractingById(Long id);

    List<ContractingDTO> getContractingByName(String name);

    List<ContractingDTO> getContractingByPrice(int price);

    List<ContractingDTO> getContractingByRegist(Date date);

    void deleteContracting(Long id);
}
