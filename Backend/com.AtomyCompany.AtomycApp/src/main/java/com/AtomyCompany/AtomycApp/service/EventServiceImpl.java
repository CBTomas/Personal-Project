package com.AtomyCompany.AtomycApp.service;

import com.AtomyCompany.AtomycApp.DTO.EventDTO;
import com.AtomyCompany.AtomycApp.DTO.GroupEventsDTO;
import com.AtomyCompany.AtomycApp.model.Event;
import com.AtomyCompany.AtomycApp.repository.EventRepository;
import com.AtomyCompany.AtomycApp.repository.GroupEventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService{
    @Autowired
    private EventRepository eventRepository;


    @Override
    public EventDTO saveEvent(EventDTO eventDTO) {

        Event event = EventDTO.convertToEntity(eventDTO);

        Event eventSaved = eventRepository.save(event);

        return EventDTO.convertToDTO(eventSaved, null);
    }

    @Override
    public EventDTO getEventById(Long id) {

        Optional<Event> event = eventRepository.findById(id);

        /*if(event.isPresent()){
            return EventDTO.convertToDTO(event.get(), null);
        }*/

        return event.map(value -> EventDTO.convertToDTO(value, null)).orElse(null);

    }

    @Override
    public List<EventDTO> getEventByName(String name) {

        List<Event> events = eventRepository.findByEventName(name);
        List<EventDTO> eventDTOList = new ArrayList<>();

        for (Event event : events){
            eventDTOList.add(EventDTO.convertToDTO(event, null));
        }

        return eventDTOList;
    }

    @Override
    public List<EventDTO> getEventByDate(Date date) {

        List<Event> events = eventRepository.findByEventDate(date);
        List<EventDTO> eventDTOList = new ArrayList<>();

        for (Event event : events){
            eventDTOList.add(EventDTO.convertToDTO(event, null));
        }

        return eventDTOList;
    }

    @Override
    public List<EventDTO> getEventByPrice(int price) {

        List<Event> events = eventRepository.findByEventPrice(price);
        List<EventDTO> eventDTOList = new ArrayList<>();

        for (Event event : events){
            eventDTOList.add(EventDTO.convertToDTO(event, null));
        }

        return eventDTOList;
    }

    @Override
    public List<EventDTO> getEventByRegist(Date date) {

        List<Event> events = eventRepository.findByRegistEvent(date);
        List<EventDTO> eventDTOList = new ArrayList<>();

        for (Event event : events){
            eventDTOList.add(EventDTO.convertToDTO(event, null));
        }

        return eventDTOList;
    }
}
