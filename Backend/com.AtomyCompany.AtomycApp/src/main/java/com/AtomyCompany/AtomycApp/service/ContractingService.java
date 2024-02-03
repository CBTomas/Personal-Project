package com.AtomyCompany.AtomycApp.service;

import com.AtomyCompany.AtomycApp.DTO.ContractingDTO;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional
public interface ContractingService {

    ContractingDTO saveContracting(ContractingDTO contractingDTO);

    ContractingDTO getContractingById(Long id);

    List<ContractingDTO> getContractingByName(String name);

    List<ContractingDTO> getContractingByPrice(int price);

    List<ContractingDTO> getContractingByRegist(LocalDate date);

    void deleteContracting(Long id);
}
