package com.AtomyCompany.AtomycApp.service;

import com.AtomyCompany.AtomycApp.DTO.EventDTO;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional
public interface EventService {

    EventDTO saveEvent(EventDTO eventDTO);
    EventDTO getEventById(Long id);
    List<EventDTO> getEventByName(String name);
    List<EventDTO> getEventByDate(LocalDate date);
    List<EventDTO> getEventByPrice(int price);
    List<EventDTO> getEventByRegist(LocalDate date);
    void deleteEvent(Long id);
}
