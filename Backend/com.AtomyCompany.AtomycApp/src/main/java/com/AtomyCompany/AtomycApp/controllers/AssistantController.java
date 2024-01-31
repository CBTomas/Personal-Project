package com.AtomyCompany.AtomycApp.controllers;
import com.AtomyCompany.AtomycApp.Application;
import com.AtomyCompany.AtomycApp.DTO.AssistantDTO;
import com.AtomyCompany.AtomycApp.service.AssistantService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
public class AssistantController {

    private static final Logger myLog= LoggerFactory.getLogger(Application.class);

    @Autowired
    private HttpServletRequest context;
    @Autowired
    AssistantService assistantService;


    @GetMapping("atomycapp/assistant") // Show All Assistants
    public ResponseEntity<List<AssistantDTO>> listAssistants(){
        myLog.info(context.getMethod() + " from " + context.getRemoteHost());
        List<AssistantDTO> assistantDTOList = assistantService.listAllAssistants();
        if (assistantDTOList==null || assistantDTOList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(assistantDTOList,HttpStatus.OK);
        }
    }

    @GetMapping("atomycapp/assistant/{idAssistant}") //Show one Assistant with ID
    public ResponseEntity<AssistantDTO> showAssistantById(@PathVariable Long idAssistant){
        myLog.info(context.getMethod() + context.getRequestURI() + " from " + context.getRemoteHost());
        AssistantDTO assistantDTO = assistantService.getAssistantById(idAssistant);
        if (assistantDTO==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(assistantDTO,HttpStatus.OK);
        }
    }

    @GetMapping("atomycapp/assistant/nm/{assistantName}") //Show All Assistants with x Name
    public ResponseEntity<List<AssistantDTO>> showAssistantsByName(@PathVariable String assistantName){
        myLog.info(context.getMethod() + " from " + context.getRemoteHost());
        List<AssistantDTO> assistantDTOList = assistantService.getAssistantByName(assistantName);
        if (assistantDTOList==null || assistantDTOList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(assistantDTOList,HttpStatus.OK);
        }
    }

    @GetMapping("atomycapp/assistant/ph/{assistantPhone}") //Show one Assistant with Phone
    public ResponseEntity<AssistantDTO> showAssistantsByPhone(@PathVariable int assistantPhone){
        myLog.info(context.getMethod() + " from " + context.getRemoteHost());
        AssistantDTO assistantDTO = assistantService.getAssistantByPhone(assistantPhone);
        if (assistantDTO==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(assistantDTO,HttpStatus.OK);
        }
    }

    @GetMapping("atomycapp/assistant/em/{assistantEmail}") //Show one Assistant with Email
    public ResponseEntity<AssistantDTO> showAssistantsByEmail(@PathVariable String assistantEmail){
        myLog.info(context.getMethod() + " from " + context.getRemoteHost());
        AssistantDTO assistantDTO = assistantService.getAssistantByEmail(assistantEmail);
        if (assistantDTO==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(assistantDTO,HttpStatus.OK);
        }
    }

    @GetMapping("atomycapp/assistant/add/{assistantAddress}") //Show one Assistant with Address
    public ResponseEntity<AssistantDTO> showAssistantsByAddress(@PathVariable String assistantAddress){
        myLog.info(context.getMethod() + " from " + context.getRemoteHost());
        AssistantDTO assistantDTO = assistantService.getAssistantByAddress(assistantAddress);
        if (assistantDTO==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(assistantDTO,HttpStatus.OK);
        }
    }

    @GetMapping("atomycapp/assistant/age/{assistantAge}") //Show All Assistants with x Age
    public ResponseEntity<List<AssistantDTO>> showAssistantsByAge(@PathVariable int assistantAge){
        myLog.info(context.getMethod() + " from " + context.getRemoteHost());
        List<AssistantDTO> assistantDTOList = assistantService.getAssistantByAge(assistantAge);
        if (assistantDTOList==null || assistantDTOList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(assistantDTOList,HttpStatus.OK);
        }
    }

    @GetMapping("atomycapp/assistant/rg/{assistantRegist}") //Show All Assistants with x Regist Date
    public ResponseEntity<List<AssistantDTO>> showAssistantsByDate(@PathVariable Date assistantRegist){
        myLog.info(context.getMethod() + " from " + context.getRemoteHost());
        List<AssistantDTO> assistantDTOList = assistantService.getAssistantByRegist(assistantRegist);
        if (assistantDTOList==null || assistantDTOList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(assistantDTOList,HttpStatus.OK);
        }
    }
    @PostMapping("atomycapp/assistant")
    public ResponseEntity<AssistantDTO> addAssistant(@RequestBody AssistantDTO assistantDTO){
        myLog.info(context.getMethod() + context.getRequestURI());
        AssistantDTO assistantSaved = assistantService.saveAssistant(assistantDTO);
        if (assistantSaved==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(assistantSaved,HttpStatus.OK);
        }
    }
    @PutMapping("atomycapp/assistant")
    public ResponseEntity<AssistantDTO> updateAssistant(@RequestBody AssistantDTO assistantDTO){
        myLog.info(context.getMethod() + context.getRequestURI());
        AssistantDTO assistantSaved = assistantService.getAssistantById(assistantDTO.getIdAssistant());
        if (assistantSaved==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            AssistantDTO assistantUPD = assistantService.saveAssistant(assistantDTO);
            return new ResponseEntity<>(assistantUPD,HttpStatus.OK);
        }
    }
    @DeleteMapping("atomycapp/assistant/{idAssistant}")
    public ResponseEntity<String> deleteAssistant(@PathVariable Long idAssistant){
        myLog.info(context.getMethod() + context.getRequestURI());
        assistantService.deleteAssistant(idAssistant);
        return new ResponseEntity<>("The assistant has been eliminated", HttpStatus.OK);
    }
}
