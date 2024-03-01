package com.AtomyCompany.AtomycApp.service;

import com.AtomyCompany.AtomycApp.DTO.EventDTO;
import com.AtomyCompany.AtomycApp.DTO.GroupEventsDTO;
import com.AtomyCompany.AtomycApp.model.Event;
import com.AtomyCompany.AtomycApp.model.GroupEvents;
import com.AtomyCompany.AtomycApp.repository.EventRepository;
import com.AtomyCompany.AtomycApp.repository.GroupEventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class GroupEventsServiceImpl implements GroupEventsService{
    @Autowired
    GroupEventsRepository groupEventsRepository;
    @Autowired
    EventRepository eventRepository;

    @Override
    public GroupEventsDTO saveGroupEvents(GroupEventsDTO groupEventsDTO) {

        GroupEvents groupEvents = GroupEventsDTO.convertToEntity(groupEventsDTO);

        GroupEvents groupEventsSaved = groupEventsRepository.save(groupEvents);

        return GroupEventsDTO.convetToDTO(groupEventsSaved);
    }

    @Override
    public List<GroupEventsDTO> listAllGroupEvents() {
        List<GroupEvents> groupEvents = groupEventsRepository.findAll();
        List<GroupEventsDTO> groupEventsDTOList = new ArrayList<>();
        for (GroupEvents groupEvent:groupEvents){
            groupEventsDTOList.add(GroupEventsDTO.convetToDTO(groupEvent));
        }
        return groupEventsDTOList;
    }

    @Override
    public GroupEventsDTO getGroupEventsById(Long id) {

        Optional<GroupEvents> groupEvents = groupEventsRepository.findById(id);

        return groupEvents.map(GroupEventsDTO::convetToDTO).orElse(null);

        /*if(groupEvents.isPresent()){
            return GroupEventsDTO.convetToDTO(groupEvents.get());
        }*/

    }

    @Override
    public List<GroupEventsDTO> getGroupEventsByName(String name) {

        List<GroupEvents> groupEvents = groupEventsRepository.findByGroupName(name);
        List<GroupEventsDTO> groupEventsDTOList = new ArrayList<>();

        for(GroupEvents groupEvents1 : groupEvents){
            groupEventsDTOList.add(GroupEventsDTO.convetToDTO(groupEvents1));
        }

        return groupEventsDTOList;
    }

    @Override
    public List<GroupEventsDTO> getGroupEventsByRegist(LocalDate date) {

        List<GroupEvents> groupEvents = groupEventsRepository.findByRegistrationDate(date);
        List<GroupEventsDTO> groupEventsDTOList = new ArrayList<>();

        for(GroupEvents groupEvents1 : groupEvents){
            groupEventsDTOList.add(GroupEventsDTO.convetToDTO(groupEvents1));
        }

        return groupEventsDTOList;
    }

    @Override
    public void deleteGroupEvents(Long id) {
        groupEventsRepository.deleteById(id);
    }

    @Override
    public String addEventToGroupEvents(Long idGroupEvents, Long idEvent) {
        GroupEvents groupEvents = groupEventsRepository.findById(idGroupEvents).orElse(null);
        Event event = eventRepository.findById(idEvent).orElse(null);
        if (event==null || groupEvents==null){
            return "GroupEvent or Event not exists.";
        }else{
            groupEvents.getEvents().add(event);
            event.setGroupEvents(groupEvents);
            groupEventsRepository.save(groupEvents);
            eventRepository.save(event);
            return "Event edded to GroupEvents";
        }
    }

    @Override
    public List<EventDTO> getEventsByGroupEvents(Long idGroupEvents) {

        List<Event> events = groupEventsRepository.getEventsByGroupEvents(idGroupEvents);

        List<EventDTO> eventDTOList = new ArrayList<>();

        for (Event event: events){
            eventDTOList.add(EventDTO.convertToDTO(event,null));
        }

        return eventDTOList;
    }
}
