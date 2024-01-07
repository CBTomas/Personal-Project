package com.AtomyCompany.AtomycApp.service;

import com.AtomyCompany.AtomycApp.DTO.EventDTO;
import com.AtomyCompany.AtomycApp.model.Event;
import jakarta.transaction.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
public interface EventService {

    EventDTO saveEvent(EventDTO eventDTO);
    EventDTO getEventById(Long id);
    List<EventDTO> getEventByName(String name);
    List<EventDTO> getEventByDate(Date date);
    List<EventDTO> getEventByPrice(int price);
    List<EventDTO> getEventByRegist(Date date);

}
