package com.AtomyCompany.AtomycApp.controllers;

import com.AtomyCompany.AtomycApp.Application;
import com.AtomyCompany.AtomycApp.DTO.ContractingDTO;
import com.AtomyCompany.AtomycApp.service.ContractingService;
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
@RequestMapping("atomycapp")
public class ContractingController {
    private static final Logger myLog= LoggerFactory.getLogger(Application.class);
    @Autowired
    private HttpServletRequest context;
    @Autowired
    ContractingService contractingService;

    @GetMapping("/contracting")
    public ResponseEntity<List<ContractingDTO>> listContractings(){
        myLog.info(context.getMethod() + " from " + context.getRemoteHost());
        List<ContractingDTO> contractingDTOList = contractingService.listAllContractings();
        if (contractingDTOList==null || contractingDTOList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(contractingDTOList,HttpStatus.OK);
        }
    }

    @GetMapping("/contracting/{idContracting}")
    public ResponseEntity<ContractingDTO> showContractingById(@PathVariable Long idContracting){
        myLog.info(context.getMethod() + " from " + context.getRemoteHost());
        ContractingDTO contractingDTO = contractingService.getContractingById(idContracting);
        if (contractingDTO==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(contractingDTO,HttpStatus.OK);
        }
    }
    @GetMapping("/contracting/nm/{name}")
    public ResponseEntity<List<ContractingDTO>> showContractingByName(@PathVariable String name){
        myLog.info(context.getMethod() + " from " + context.getRemoteHost());
        List<ContractingDTO> contractingDTOList = contractingService.getContractingByName(name);
        if (contractingDTOList==null || contractingDTOList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(contractingDTOList,HttpStatus.OK);
        }
    }

    @GetMapping("/contracting/prc/{price}")
    public ResponseEntity<List<ContractingDTO>> showContractingByPrice(@PathVariable int price){
        myLog.info(context.getMethod() + " from " + context.getRemoteHost());
        List<ContractingDTO> contractingDTOList = contractingService.getContractingByPrice(price);
        if (contractingDTOList==null || contractingDTOList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(contractingDTOList,HttpStatus.OK);
        }
    }

    @GetMapping("/contracting/rgst/{date}")
    public ResponseEntity<List<ContractingDTO>> showContractingByRegist(@PathVariable LocalDate date){
        myLog.info(context.getMethod() + " from " + context.getRemoteHost());
        List<ContractingDTO> contractingDTOList = contractingService.getContractingByRegist(date);
        if (contractingDTOList==null || contractingDTOList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(contractingDTOList,HttpStatus.OK);
        }
    }

    @PostMapping("/contracting")
    public ResponseEntity<ContractingDTO> addContracting(@RequestBody ContractingDTO contractingDTO){
        myLog.info(context.getMethod() + " from " + context.getRemoteHost());
        ContractingDTO contractingSaved = contractingService.saveContracting(contractingDTO);
        if(contractingSaved==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(contractingSaved,HttpStatus.OK);
        }
    }
    @PutMapping("/contracting")
    public ResponseEntity<ContractingDTO> updateContracting(@RequestBody ContractingDTO contractingDTO){
        myLog.info(context.getMethod() + " from " + context.getRemoteHost());
        ContractingDTO contractingSaved = contractingService.getContractingById(contractingDTO.getIdContracting());
        if (contractingSaved==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            ContractingDTO contractingUPD = contractingService.saveContracting(contractingDTO);
            return new ResponseEntity<>(contractingUPD,HttpStatus.OK);
        }
    }
    @DeleteMapping("/contracting/{idContracting}")
    public ResponseEntity<String> deleteContracting(@PathVariable Long idContracting){
        myLog.info(context.getMethod() + context.getRequestURI());
        contractingService.deleteContracting(idContracting);
        return new ResponseEntity<>("The Contracting has been eliminated",HttpStatus.OK);
    }
}
