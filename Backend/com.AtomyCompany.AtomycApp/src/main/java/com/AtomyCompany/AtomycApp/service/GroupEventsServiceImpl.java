package com.AtomyCompany.AtomycApp.service;

import com.AtomyCompany.AtomycApp.DTO.GroupEventsDTO;
import com.AtomyCompany.AtomycApp.model.GroupEvents;
import com.AtomyCompany.AtomycApp.repository.GroupEventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class GroupEventsServiceImpl implements GroupEventsService{
    @Autowired
    GroupEventsRepository groupEventsRepository;

    @Override
    public GroupEventsDTO saveGroupEvents(GroupEventsDTO groupEventsDTO) {

        GroupEvents groupEvents = GroupEventsDTO.convertToEntity(groupEventsDTO);

        GroupEvents groupEventsSaved = groupEventsRepository.save(groupEvents);

        return GroupEventsDTO.convetToDTO(groupEventsSaved);
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
    public List<GroupEventsDTO> getGroupEventsByRegist(Date date) {

        List<GroupEvents> groupEvents = groupEventsRepository.findByRegistGroup(date);
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
}
