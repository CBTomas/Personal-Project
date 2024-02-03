package com.AtomyCompany.AtomycApp.service;

import com.AtomyCompany.AtomycApp.DTO.AssistantDTO;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Transactional
public interface AssistantService {

    AssistantDTO saveAssistant(AssistantDTO assistantDTO);

    List<AssistantDTO> listAllAssistants();

    AssistantDTO getAssistantById(Long id);

    List<AssistantDTO> getAssistantByName(String name);

    AssistantDTO getAssistantByPhone(String phone);

    AssistantDTO getAssistantByEmail(String email);

    AssistantDTO getAssistantByAddress(String Address);

    List<AssistantDTO> getAssistantByAge(int age);

    List<AssistantDTO> getAssistantByRegist(LocalDate date);

    void deleteAssistant(Long id);
}
