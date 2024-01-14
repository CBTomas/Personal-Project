package com.AtomyCompany.AtomycApp.service;

import com.AtomyCompany.AtomycApp.DTO.AssistantDTO;
import jakarta.transaction.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
public interface AssistantService {

    AssistantDTO saveAssistant(AssistantDTO assistantDTO);

    AssistantDTO getAssistantById(Long id);

    List<AssistantDTO> getAssistantByName(String name);

    AssistantDTO getAssistantByPhone(int phone);

    AssistantDTO getAssistantByEmail(String email);

    AssistantDTO getAssistantByAddress(String Address);

    List<AssistantDTO> getAssistantByAge(int age);

    List<AssistantDTO> getAssistantByRegist(Date date);

    void deleteAssistant(Long id);
}
