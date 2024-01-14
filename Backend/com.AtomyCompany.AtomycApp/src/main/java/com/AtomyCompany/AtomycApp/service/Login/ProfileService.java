package com.AtomyCompany.AtomycApp.service.Login;

import com.AtomyCompany.AtomycApp.DTO.Login.ProfileDTO;
import jakarta.transaction.Transactional;

@Transactional
public interface ProfileService {

    ProfileDTO saveProfile(ProfileDTO profileDTO);

    ProfileDTO getProfileById(Long id);

    ProfileDTO getProfileByName(String name);

    void deleteProfile(Long id);

}
