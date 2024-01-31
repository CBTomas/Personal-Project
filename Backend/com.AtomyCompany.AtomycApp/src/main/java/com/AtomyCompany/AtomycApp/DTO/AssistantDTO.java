package com.AtomyCompany.AtomycApp.DTO;

import com.AtomyCompany.AtomycApp.model.Assistant;
import com.AtomyCompany.AtomycApp.model.Event;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class AssistantDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 4L;

    // DTO parameters
    private Long idAssistant;
    private String assistantName;
    private int assistantPhone;
    private String assistantEmail;
    private String assistantAddress;
    private int assistantAge;
    private Date registAssistant;

    // Events attended.
    @ToString.Exclude
    @JsonIgnore
    private List<Event> eventAssist = new ArrayList<>();

    // Function that converts the object entity to dto
    public static AssistantDTO convertToDTO(Assistant assistant){

        AssistantDTO assistantDTO = new AssistantDTO();

        assistantDTO.setIdAssistant(assistant.getIdAssistant());
        assistantDTO.setAssistantName(assistant.getAssistantName());
        assistantDTO.setAssistantPhone(assistant.getAssistantPhone());
        assistantDTO.setAssistantEmail(assistant.getAssistantEmail());
        assistantDTO.setAssistantAddress(assistant.getAssistantAddress());
        assistantDTO.setAssistantAge(assistant.getAssistantAge());
        assistantDTO.setRegistAssistant(assistant.getAssistantRegist());

        return assistantDTO;
    }

    // Function that converts the dto object to an entity
    public static Assistant convertToEntity(AssistantDTO assistantDTO){

        Assistant assistant = new Assistant();

        assistant.setIdAssistant(assistantDTO.getIdAssistant());
        assistant.setAssistantName(assistantDTO.getAssistantName());
        assistant.setAssistantPhone(assistantDTO.getAssistantPhone());
        assistant.setAssistantEmail(assistantDTO.getAssistantEmail());
        assistant.setAssistantAddress(assistantDTO.getAssistantAddress());
        assistant.setAssistantAge(assistantDTO.getAssistantAge());
        assistant.setAssistantRegist(assistantDTO.getRegistAssistant());

        return assistant;
    }
}
