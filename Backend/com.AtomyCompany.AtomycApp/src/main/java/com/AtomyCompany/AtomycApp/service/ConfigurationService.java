package com.AtomyCompany.AtomycApp.service;

import com.AtomyCompany.AtomycApp.DTO.ConfigurationDTO;
import jakarta.transaction.Transactional;

@Transactional
public interface ConfigurationService {

    ConfigurationDTO saveConfiguration(ConfigurationDTO configurationDTO);

    ConfigurationDTO getConfigurationById(String name);

    void deleteConfiguration(String name);

}
