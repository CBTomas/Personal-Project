package com.AtomyCompany.AtomycApp.DTO.Login;

import com.AtomyCompany.AtomycApp.model.LogIn.Profile;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProfileDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 4L;

    private Long idProfile;
    private String nameProfile;

    @ToString.Exclude
    @JsonIgnore
    private List<UsersDTO> userDTO = new ArrayList<>();

    public static ProfileDTO convertToDTO(Profile profile){

        ProfileDTO profileDTO = new ProfileDTO();

        profileDTO.setIdProfile(profile.getIdProfile());
        profileDTO.setNameProfile(profile.getNameProfile());

        return profileDTO;
    }
}
