package com.AtomyCompany.AtomycApp.service;

import com.AtomyCompany.AtomycApp.DTO.ContractingDTO;
import com.AtomyCompany.AtomycApp.model.Contracting;
import com.AtomyCompany.AtomycApp.repository.ContractingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContractingServiceImpl implements ContractingService{

    @Autowired
    private ContractingRepository contractingRepository;


    @Override
    public ContractingDTO saveContracting(ContractingDTO contractingDTO) {

        Contracting contracting = ContractingDTO.convertToEntity(contractingDTO);

        Contracting contractingSaved = contractingRepository.save(contracting);

        return ContractingDTO.convertToDTO(contractingSaved, null);
    }

    @Override
    public List<ContractingDTO> listAllContractings() {
        List<Contracting> contractings = contractingRepository.findAll();
        List<ContractingDTO> contractingDTOList = new ArrayList<>();
        for (Contracting contracting:contractings){
            contractingDTOList.add(ContractingDTO.convertToDTO(contracting,null));
        }
        return contractingDTOList;
    }

    @Override
    public ContractingDTO getContractingById(Long id) {

        Optional<Contracting> contracting = contractingRepository.findById(id);

        return contracting.map(value -> ContractingDTO.convertToDTO(value, null)).orElse(null);

    }

    @Override
    public List<ContractingDTO> getContractingByName(String name) {

        List<Contracting> contractings = contractingRepository.findByContractingName(name);
        List<ContractingDTO> contractingDTOList = new ArrayList<>();

        for (Contracting contracting : contractings){
            contractingDTOList.add(ContractingDTO.convertToDTO(contracting,null));
        }

        return contractingDTOList;
    }

    @Override
    public List<ContractingDTO> getContractingByPrice(int price) {

        List<Contracting> contractings = contractingRepository.findByPrice(price);
        List<ContractingDTO> contractingDTOList = new ArrayList<>();

        for (Contracting contracting : contractings){
            contractingDTOList.add(ContractingDTO.convertToDTO(contracting,null));
        }

        return contractingDTOList;
    }

    @Override
    public List<ContractingDTO> getContractingByRegist(LocalDate date) {

        List<Contracting> contractings = contractingRepository.findByRegistrationDate(date);
        List<ContractingDTO> contractingDTOList = new ArrayList<>();

        for (Contracting contracting : contractings){
            contractingDTOList.add(ContractingDTO.convertToDTO(contracting,null));
        }

        return contractingDTOList;
    }

    @Override
    public void deleteContracting(Long id) {
        contractingRepository.deleteById(id);
    }
}
