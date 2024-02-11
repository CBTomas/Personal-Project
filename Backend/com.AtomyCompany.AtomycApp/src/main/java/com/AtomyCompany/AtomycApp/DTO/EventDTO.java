package com.AtomyCompany.AtomycApp.DTO;

import com.AtomyCompany.AtomycApp.model.Assistant;
import com.AtomyCompany.AtomycApp.model.Contracting;
import com.AtomyCompany.AtomycApp.model.Event;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class EventDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 4L;

    private Long idEvent;
    private String eventName;
    private LocalDate eventDate;
    private int eventPrice;
    private int assistantPrice;
    private LocalDate registrationDate;

    @ToString.Exclude
    @JsonIgnore
    private List<AssistantDTO> assistantsEvent = new ArrayList<>();

    @ToString.Exclude
    @JsonIgnore
    private List<ContractingDTO> contractions = new ArrayList<>();

    @ToString.Exclude
    @JsonIgnore
    private GroupEventsDTO groupEvents;

    public static EventDTO convertToDTO(Event event, GroupEventsDTO groupEventsDTO){

        EventDTO eventDTO = new EventDTO();

        eventDTO.setIdEvent(event.getIdEvent());
        eventDTO.setEventName(event.getEventName());
        eventDTO.setEventDate(event.getEventDate());
        eventDTO.setEventPrice(event.getEventPrice());
        eventDTO.setAssistantPrice(event.getAssistantPrice());
        eventDTO.setRegistrationDate(event.getRegistrationDate());

        if (groupEventsDTO != null){
            eventDTO.setGroupEvents(groupEventsDTO);
        }else{
            if (event.getGroupEvents() != null){
                eventDTO.setGroupEvents(GroupEventsDTO.convetToDTO(event.getGroupEvents()));
            }
        }

        return eventDTO;
    }

    public static Event convertToEntity(EventDTO eventDTO){

        Event event = new Event();

        event.setIdEvent(eventDTO.getIdEvent());
        event.setEventName(eventDTO.getEventName());
        event.setEventDate(eventDTO.getEventDate());
        event.setEventPrice(eventDTO.getEventPrice());
        event.setAssistantPrice(eventDTO.getAssistantPrice());
        event.setRegistrationDate(eventDTO.getRegistrationDate());

        return event;
    }

}
