package com.AtomyCompany.AtomycApp.service;

import com.AtomyCompany.AtomycApp.DTO.ConfigurationDTO;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public interface ConfigurationService {

    ConfigurationDTO saveConfiguration(ConfigurationDTO configurationDTO);

    ConfigurationDTO getConfigurationById(String name);

    void deleteConfiguration(String name);

    List<ConfigurationDTO> listAllConfigurations();

}
