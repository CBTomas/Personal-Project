package com.AtomyCompany.AtomycApp.service;

import com.AtomyCompany.AtomycApp.DTO.ConfigurationDTO;
import com.AtomyCompany.AtomycApp.model.Configuration;
import com.AtomyCompany.AtomycApp.repository.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConfigurationServiceImpl implements ConfigurationService{

    @Autowired
    private ConfigurationRepository configurationRepository;

    @Override
    public ConfigurationDTO saveConfiguration(ConfigurationDTO configurationDTO) {

        Configuration configuration = ConfigurationDTO.convertToEntity(configurationDTO);

        Configuration configurationSaved = configurationRepository.save(configuration);

        return ConfigurationDTO.convertToDTO(configurationSaved);
    }

    @Override
    public ConfigurationDTO getConfigurationById(String name) {

        Optional<Configuration> configuration = configurationRepository.findById(name);

        return configuration.map(ConfigurationDTO::convertToDTO).orElse(null);

    }

    @Override
    public void deleteConfiguration(String name) {
        configurationRepository.deleteById(name);
    }

    @Override
    public List<ConfigurationDTO> listAllConfigurations() {

        List<Configuration> configurations = configurationRepository.findAll();
        List<ConfigurationDTO> configurationDTOList = new ArrayList<>();

        for (Configuration configuration: configurations){
            configurationDTOList.add(ConfigurationDTO.convertToDTO(configuration));
        }
        return configurationDTOList;
    }
}
