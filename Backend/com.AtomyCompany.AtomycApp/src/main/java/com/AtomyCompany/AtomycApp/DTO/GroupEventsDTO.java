package com.AtomyCompany.AtomycApp.DTO;

import com.AtomyCompany.AtomycApp.model.GroupEvents;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class GroupEventsDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 4L;

    private Long groupEventsID;
    private String groupName;
    private Date registGroup;

    @ToString.Exclude
    @JsonIgnore
    private List<EventDTO> eventDTO = new ArrayList<>();

    public static GroupEventsDTO convetToDTO(GroupEvents groupEvents){

        GroupEventsDTO groupEventsDTO = new GroupEventsDTO();

        groupEventsDTO.setGroupEventsID(groupEvents.getGroupEventsID());
        groupEventsDTO.setGroupName(groupEvents.getGroupName());
        groupEventsDTO.setRegistGroup(groupEvents.getRegistGroup());

        return groupEventsDTO;
    }

    public static GroupEvents convertToEntity(GroupEventsDTO groupEventsDTO){

        GroupEvents groupEvents = new GroupEvents();

        groupEvents.setGroupEventsID(groupEventsDTO.getGroupEventsID());
        groupEvents.setGroupName(groupEventsDTO.getGroupName());
        groupEvents.setRegistGroup(groupEventsDTO.getRegistGroup());

        return groupEvents;
    }
}
