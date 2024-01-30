package com.AtomyCompany.AtomycApp.service;

import com.AtomyCompany.AtomycApp.DTO.AssistantDTO;
import com.AtomyCompany.AtomycApp.model.Assistant;
import com.AtomyCompany.AtomycApp.repository.AssistantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AssistantServiceImpl implements AssistantService{

    @Autowired
    private AssistantRepository assistantRepository;

    @Override
    public AssistantDTO saveAssistant(AssistantDTO assistantDTO) {

        // Convert DTO to Entity to save it
        Assistant assistant = AssistantDTO.convertToEntity(assistantDTO);

        // We instantiate again to pick up the object saved with id
        Assistant assistantSaved = assistantRepository.save(assistant);

        // We return the converted object to DTO
        return AssistantDTO.convertToDTO(assistantSaved);
    }

    @Override
    public List<AssistantDTO> listAllAssistants() {

        List<Assistant> assistants = assistantRepository.findAll();
        List<AssistantDTO> assistantDTOList = new ArrayList<>();
        for (Assistant assistant: assistants){
            assistantDTOList.add(AssistantDTO.convertToDTO(assistant));
        }
        return assistantDTOList;
    }

    @Override
    public AssistantDTO getAssistantById(Long id) {

        Optional<Assistant> assistant = assistantRepository.findById(id);

        /*if(assistant.isPresent()){
            return AssistantDTO.convertToDTO(assistant.get());
        }*/

        return assistant.map(AssistantDTO::convertToDTO).orElse(null);

    }

    @Override
    public List<AssistantDTO> getAssistantByName(String name) {

        List<Assistant> assistants = assistantRepository.findByAssistantName(name);
        List<AssistantDTO> listAssistant = new ArrayList<>();

        for (Assistant assistant : assistants) {
            listAssistant.add(AssistantDTO.convertToDTO(assistant));
        }

        return listAssistant;
    }

    @Override
    public AssistantDTO getAssistantByPhone(int phone) {

        Assistant assistant = assistantRepository.findByAssistantPhone(phone);

        return AssistantDTO.convertToDTO(assistant);
    }

    @Override
    public AssistantDTO getAssistantByEmail(String email) {

        Assistant assistant = assistantRepository.findByAssistantEmail(email);

        return AssistantDTO.convertToDTO(assistant);
    }

    @Override
    public AssistantDTO getAssistantByAddress(String address) {

        Assistant assistant = assistantRepository.findByAssistantAddress(address);

        return AssistantDTO.convertToDTO(assistant);
    }

    @Override
    public List<AssistantDTO> getAssistantByAge(int age) {

        List<Assistant> assistants = assistantRepository.findByAssistantAge(age);

        List<AssistantDTO> assistantDTOList = new ArrayList<>();

        for (Assistant assistant : assistants){
            assistantDTOList.add(AssistantDTO.convertToDTO(assistant));
        }

        return assistantDTOList;
    }

    @Override
    public List<AssistantDTO> getAssistantByRegist(Date date) {

        List<Assistant> assistants = assistantRepository.findByAssistantRegist(date);

        List<AssistantDTO> assistantDTOList = new ArrayList<>();

        for (Assistant assistant : assistants){
            assistantDTOList.add(AssistantDTO.convertToDTO(assistant));
        }

        return assistantDTOList;
    }

    @Override
    public void deleteAssistant(Long id) {
        assistantRepository.deleteById(id);
    }
}
