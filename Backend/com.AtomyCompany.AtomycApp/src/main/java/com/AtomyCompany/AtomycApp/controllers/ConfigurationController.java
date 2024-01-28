package com.AtomyCompany.AtomycApp.controllers;

import com.AtomyCompany.AtomycApp.Application;
import com.AtomyCompany.AtomycApp.DTO.ConfigurationDTO;
import com.AtomyCompany.AtomycApp.service.ConfigurationService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ConfigurationController {

    private static final Logger myLog= LoggerFactory.getLogger(Application.class);

    @Autowired
    private HttpServletRequest context;

    @Autowired
    ConfigurationService configurationService;

    @GetMapping("atomycapp/configuration/{idConfiguration}")
    public ResponseEntity<ConfigurationDTO> showConfigurationById(@PathVariable String idConfiguration){
        myLog.info(context.getMethod() + context.getRequestURI() + " from " + context.getRemoteHost());
        ConfigurationDTO configurationDTO = configurationService.getConfigurationById(idConfiguration);
        if (configurationDTO==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(configurationDTO,HttpStatus.OK);
        }
    }

    @GetMapping("atomycapp/configurations")
    public ResponseEntity<List<ConfigurationDTO>> listConfiguration(){
        myLog.info(context.getMethod() + " from " + context.getRemoteHost());
        List<ConfigurationDTO> configurationDTOList = configurationService.listAllConfigurations();
        if (configurationDTOList==null || configurationDTOList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(configurationDTOList,HttpStatus.OK);
        }
    }

    @PostMapping("atomycapp/configuration")
    public ResponseEntity<ConfigurationDTO> addConfiguration(@RequestBody ConfigurationDTO configurationDTO){
        myLog.info(context.getMethod() + context.getRequestURI());

        ConfigurationDTO configurationSaved = configurationService.saveConfiguration(configurationDTO);
        if (configurationSaved==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(configurationSaved,HttpStatus.OK);
        }
    }

    @PutMapping("atomycapp/configuration")
    public ResponseEntity<ConfigurationDTO> updateConfiguiration(@RequestBody ConfigurationDTO configurationUpd){
        myLog.info(context.getMethod() + context.getRequestURI());
        ConfigurationDTO configurationSaved = configurationService.getConfigurationById(configurationUpd.getName());
        if (configurationSaved==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            ConfigurationDTO configurationUPD = configurationService.saveConfiguration(configurationUpd);
            return new ResponseEntity<>(configurationUPD,HttpStatus.OK);
        }
    }

    @DeleteMapping("atomycapp/configuration/{idConfiguration}")
    public ResponseEntity<String> deleteConfiguration(@PathVariable String idConfiguration){
        myLog.info(context.getMethod() + context.getRequestURI());
        configurationService.deleteConfiguration(idConfiguration);
        return new ResponseEntity<>("The configuration has been eliminated", HttpStatus.OK);
    }
}
