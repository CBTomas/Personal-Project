package com.AtomyCompany.AtomycApp.DTO;

import com.AtomyCompany.AtomycApp.model.Configuration;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class ConfigurationDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 4L;

    private String name;
    private String parameter;

    public static ConfigurationDTO convertToDTO(Configuration configuration){

        ConfigurationDTO configurationDTO = new ConfigurationDTO();

        configurationDTO.setName(configuration.getName());
        configurationDTO.setParameter(configuration.getParameter());

        return configurationDTO;
    }

    public static Configuration convertToEntity(ConfigurationDTO configurationDTO){

        Configuration configuration = new Configuration();

        configuration.setName(configurationDTO.getName());
        configuration.setParameter(configurationDTO.getParameter());

        return configuration;
    }
}
