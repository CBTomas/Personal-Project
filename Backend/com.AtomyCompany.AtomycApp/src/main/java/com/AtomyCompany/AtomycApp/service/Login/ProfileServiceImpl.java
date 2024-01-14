package com.AtomyCompany.AtomycApp.service.Login;

import com.AtomyCompany.AtomycApp.DTO.Login.ProfileDTO;
import com.AtomyCompany.AtomycApp.model.LogIn.Profile;
import com.AtomyCompany.AtomycApp.repository.LogIn.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public ProfileDTO saveProfile(ProfileDTO profileDTO) {

        Profile profile = ProfileDTO.convertToEntity(profileDTO);

        Profile profileSaved = profileRepository.save(profile);

        return ProfileDTO.convertToDTO(profileSaved);
    }

    @Override
    public ProfileDTO getProfileById(Long id) {

        Optional<Profile> profile = profileRepository.findById(id);

        return profile.map(ProfileDTO::convertToDTO).orElse(null);

    }

    @Override
    public ProfileDTO getProfileByName(String name) {

        Profile profile = profileRepository.findByNameProfile(name);

        return ProfileDTO.convertToDTO(profile);
    }

    @Override
    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
    }
}
