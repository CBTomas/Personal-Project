package com.AtomyCompany.AtomycApp.controllers;

import com.AtomyCompany.AtomycApp.Application;
import com.AtomyCompany.AtomycApp.DTO.GroupEventsDTO;
import com.AtomyCompany.AtomycApp.service.GroupEventsService;
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
public class GroupEventsController {

    private static final Logger myLog= LoggerFactory.getLogger(Application.class);

    @Autowired
    private HttpServletRequest context;

    @Autowired
    GroupEventsService groupEventsService;
    @GetMapping("atomycapp/groupevents")
    public ResponseEntity<List<GroupEventsDTO>> listGroupEvents(){
        myLog.info(context.getMethod() + " from " + context.getRemoteHost());
        List<GroupEventsDTO> groupEventsDTOList = groupEventsService.listAllGroupEvents();
        if (groupEventsDTOList==null || groupEventsDTOList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(groupEventsDTOList,HttpStatus.OK);
        }
    }
    @GetMapping("atomycapp/groupevents/{idGroupEvents}")
    public ResponseEntity<GroupEventsDTO> showGroupEventsById(@PathVariable Long idGroupEvents){
        myLog.info(context.getMethod() + " from " + context.getRemoteHost());
        GroupEventsDTO groupEventsDTO = groupEventsService.getGroupEventsById(idGroupEvents);
        if (groupEventsDTO==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(groupEventsDTO,HttpStatus.OK);
        }
    }
    @GetMapping("atomycapp/groupevents/nm/{name}")
    public ResponseEntity<List<GroupEventsDTO>> showGroupEventsByName(@PathVariable String name){
        myLog.info(context.getMethod() + " from " + context.getRemoteHost());
        List<GroupEventsDTO> groupEventsDTO = groupEventsService.getGroupEventsByName(name);
        if (groupEventsDTO==null || groupEventsDTO.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(groupEventsDTO,HttpStatus.OK);
        }
    }

    @GetMapping("atomycapp/groupevents/rgst/{date}")
    public ResponseEntity<List<GroupEventsDTO>> showGroupEventsByRegist(@PathVariable LocalDate date){
        myLog.info(context.getMethod() + " from " + context.getRemoteHost());
        List<GroupEventsDTO> groupEventsDTO = groupEventsService.getGroupEventsByRegist(date);
        if (groupEventsDTO==null || groupEventsDTO.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(groupEventsDTO,HttpStatus.OK);
        }
    }
    @PostMapping("atomycapp/groupevents")
    public ResponseEntity<GroupEventsDTO> addGroupEvents(@RequestBody GroupEventsDTO groupEventsDTO){
        myLog.info(context.getMethod() + " from " + context.getRemoteHost());
        GroupEventsDTO groupEventsSaved = groupEventsService.saveGroupEvents(groupEventsDTO);
        if (groupEventsSaved==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(groupEventsSaved,HttpStatus.OK);
        }
    }
    @PutMapping("atomycapp/groupevents")
    public ResponseEntity<GroupEventsDTO> updateGroupEvents(@RequestBody GroupEventsDTO groupEventsDTO){
        myLog.info(context.getMethod() + " from " + context.getRemoteHost());
        GroupEventsDTO groupEventsSaved = groupEventsService.getGroupEventsById(groupEventsDTO.getGroupEventsID());
        if (groupEventsSaved==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            GroupEventsDTO groupEventsUPD = groupEventsService.saveGroupEvents(groupEventsDTO);
            return new ResponseEntity<>(groupEventsUPD,HttpStatus.OK);
        }
    }

    @DeleteMapping("atomycapp/groupevents/{idGroupEvents}")
    public ResponseEntity<String> deleteGroupEvents(@PathVariable Long idGroupEvents){
        myLog.info(context.getMethod() + context.getRequestURI());
        groupEventsService.deleteGroupEvents(idGroupEvents);
        return new ResponseEntity<>("The GroupEvents has been eliminated",HttpStatus.OK);
    }
}
