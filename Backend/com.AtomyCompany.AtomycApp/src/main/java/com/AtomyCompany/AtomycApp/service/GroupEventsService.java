package com.AtomyCompany.AtomycApp.service;

import com.AtomyCompany.AtomycApp.DTO.EventDTO;
import com.AtomyCompany.AtomycApp.DTO.GroupEventsDTO;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Transactional
public interface GroupEventsService {

    GroupEventsDTO saveGroupEvents(GroupEventsDTO groupEventsDTO);

    List<GroupEventsDTO> listAllGroupEvents();

    GroupEventsDTO getGroupEventsById(Long id);

    List<GroupEventsDTO> getGroupEventsByName(String name);

    List<GroupEventsDTO> getGroupEventsByRegist(LocalDate date);

    void deleteGroupEvents(Long id);

    String addEventToGroupEvents(Long idGroupEvents, Long idEvent);

    List<EventDTO> getEventsByGroupEvents(Long idGroupEvents);
}
