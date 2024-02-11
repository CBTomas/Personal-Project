package com.AtomyCompany.AtomycApp.controllers;

import com.AtomyCompany.AtomycApp.Application;
import com.AtomyCompany.AtomycApp.DTO.EventDTO;
import com.AtomyCompany.AtomycApp.service.AssistantService;
import com.AtomyCompany.AtomycApp.service.EventService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class EventController {

    private static final Logger myLog= LoggerFactory.getLogger(Application.class);

    @Autowired
    private HttpServletRequest context;

    @Autowired
    EventService eventService;

    @Autowired
    AssistantService assistantService;

    @GetMapping("atomycapp/event")
    public ResponseEntity<List<EventDTO>> listEvents(){
        myLog.info(context.getMethod() + " from " + context.getRemoteHost());
        List<EventDTO> eventDTOList = eventService.listAllEvents();
        if (eventDTOList==null || eventDTOList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(eventDTOList,HttpStatus.OK);
        }
    }

    @GetMapping("atomycapp/event/{idEvent}")
    public ResponseEntity<EventDTO> showEventById(@PathVariable Long idEvent){
        myLog.info(context.getMethod() + " from " + context.getRemoteHost());
        EventDTO eventDTO = eventService.getEventById(idEvent);
        if (eventDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(eventDTO,HttpStatus.OK);
        }
    }

    @GetMapping("atomycapp/event/nm/{eventName}")
    public ResponseEntity<List<EventDTO>> showEventsByName(@PathVariable String eventName){
        myLog.info(context.getMethod() + " from " + context.getRemoteHost());
        List<EventDTO> events = eventService.getEventByName(eventName);
        if (events==null || events.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(events,HttpStatus.OK);
        }
    }
    @GetMapping("atomycapp/event/dt/{date}")
    public ResponseEntity<List<EventDTO>> showEventsByDate(@PathVariable LocalDate date){
        myLog.info(context.getMethod() + " from " + context.getRemoteHost());
        List<EventDTO> events = eventService.getEventByDate(date);
        if (events==null || events.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(events,HttpStatus.OK);
        }
    }

    @GetMapping("atomycapp/event/prc/{price}")
    public ResponseEntity<List<EventDTO>> showEventsByPrice(@PathVariable int price){
        myLog.info(context.getMethod() + " from " + context.getRemoteHost());
        List<EventDTO> events = eventService.getEventByPrice(price);
        if (events==null || events.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(events,HttpStatus.OK);
        }
    }

    @GetMapping("atomycapp/event/rgst/{date}")
    public ResponseEntity<List<EventDTO>> showEventsByRegist(@PathVariable LocalDate date){
        myLog.info(context.getMethod() + " from " + context.getRemoteHost());
        List<EventDTO> events = eventService.getEventByRegist(date);
        if (events==null || events.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(events,HttpStatus.OK);
        }
    }
    @PostMapping("atomycapp/event")
    public ResponseEntity<EventDTO> addEvent(@RequestBody EventDTO eventDTO){
        myLog.info(context.getMethod() + " from " + context.getRemoteHost());
        EventDTO eventSaved = eventService.saveEvent(eventDTO);
        if (eventSaved==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(eventSaved,HttpStatus.OK);
        }
    }

    @PutMapping("atomycapp/event")
    public ResponseEntity<EventDTO> updateEvent(@RequestBody EventDTO eventDTO){
        myLog.info(context.getMethod() + " from " + context.getRemoteHost());
        EventDTO eventSaved = eventService.getEventById(eventDTO.getIdEvent());
        if (eventSaved==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            EventDTO eventUPD = eventService.saveEvent(eventDTO);
            return new ResponseEntity<>(eventUPD,HttpStatus.OK);
        }
    }

    @PutMapping("atomycapp/event/AssEv/{idAssistant}/{idEvent}")
    public String addAssistantToEvent(
        @PathVariable Long idAssistant,
        @PathVariable Long idEvent){
        myLog.info(context.getMethod() + " from " + context.getRemoteHost());
        return eventService.addAssistantToEvent(idAssistant,idEvent);
    }

    @DeleteMapping("atomycapp/event/{idEvent}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long idEvent){
        myLog.info(context.getMethod() + context.getRequestURI());
        eventService.deleteEvent(idEvent);
        return new ResponseEntity<>("The event has been eliminated",HttpStatus.OK);
    }
}
