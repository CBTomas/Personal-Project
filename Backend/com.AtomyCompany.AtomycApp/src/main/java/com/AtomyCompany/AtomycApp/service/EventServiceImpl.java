package com.AtomyCompany.AtomycApp.service;

import com.AtomyCompany.AtomycApp.DTO.ContractingDTO;
import com.AtomyCompany.AtomycApp.DTO.EventDTO;
import com.AtomyCompany.AtomycApp.model.Assistant;
import com.AtomyCompany.AtomycApp.model.Contracting;
import com.AtomyCompany.AtomycApp.model.Event;
import com.AtomyCompany.AtomycApp.repository.AssistantRepository;
import com.AtomyCompany.AtomycApp.repository.ContractingRepository;
import com.AtomyCompany.AtomycApp.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService{
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private AssistantRepository assistantRepository;
    @Autowired
    private ContractingRepository contractingRepository;


    @Override
    public EventDTO saveEvent(EventDTO eventDTO) {

        Event event = EventDTO.convertToEntity(eventDTO);

        Event eventSaved = eventRepository.save(event);

        return EventDTO.convertToDTO(eventSaved, null);
    }

    @Override
    public List<EventDTO> listAllEvents() {
        List<Event> events = eventRepository.findAll();
        List<EventDTO> eventDTOList = new ArrayList<>();
        for (Event event: events){
            eventDTOList.add(EventDTO.convertToDTO(event,null));
        }
        return eventDTOList;
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
    public List<EventDTO> getEventByDate(LocalDate date) {

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
    public List<EventDTO> getEventByRegist(LocalDate date) {

        List<Event> events = eventRepository.findByRegistrationDate(date);
        List<EventDTO> eventDTOList = new ArrayList<>();

        for (Event event : events){
            eventDTOList.add(EventDTO.convertToDTO(event, null));
        }

        return eventDTOList;
    }

    @Override
    public String addAssistantToEvent(Long idAssistant, Long idEvent) {
        Assistant assistant = assistantRepository.findById(idAssistant).orElse(null);
        Event event = eventRepository.findById(idEvent).orElse(null);
        if (assistant==null || event==null){
            return "Assistant or Event not exists.";
        }else{
            assistant.getEventsAssist().add(event);
            event.getAssistantsEvent().add(assistant);
            assistantRepository.save(assistant);
            eventRepository.save(event);
            return "Attendee has been saved in the event";
        }
    }

    @Override
    public String addContractingToEvent(Long idEvent, Long idContracting) {
        Contracting contracting = contractingRepository.findById(idContracting).orElse(null);
        Event event = eventRepository.findById(idEvent).orElse(null);
        if (event==null || contracting==null){
            return "Assistant or Event not exists.";
        }else{
            event.getContractions().add(contracting);
            contracting.setEventContracting(event);
            eventRepository.save(event);
            contractingRepository.save(contracting);
            return "Hiring added to the event";
        }
    }

    @Override
    public List<ContractingDTO> getContractingsByEvent(Long idEvent) {

        List<Contracting> contractings = eventRepository.getContractingsByEvent(idEvent);

        List<ContractingDTO> contractingDTOList = new ArrayList<>();

        for(Contracting contracting: contractings){
            contractingDTOList.add(ContractingDTO.convertToDTO(contracting,null));
        }

        return contractingDTOList;
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
