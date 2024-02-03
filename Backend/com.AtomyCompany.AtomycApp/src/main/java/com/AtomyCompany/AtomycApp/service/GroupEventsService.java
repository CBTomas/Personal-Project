package com.AtomyCompany.AtomycApp.service;

import com.AtomyCompany.AtomycApp.DTO.GroupEventsDTO;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Transactional
public interface GroupEventsService {

    GroupEventsDTO saveGroupEvents(GroupEventsDTO groupEventsDTO);

    GroupEventsDTO getGroupEventsById(Long id);

    List<GroupEventsDTO> getGroupEventsByName(String name);

    List<GroupEventsDTO> getGroupEventsByRegist(LocalDate date);

    void deleteGroupEvents(Long id);

}
