package com.AtomyCompany.AtomycApp.repository.LogIn;

import com.AtomyCompany.AtomycApp.model.LogIn.Profile;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ProfileRepository  extends JpaRepository<Profile, Long> {

    Profile findByNameProfile(String name);
}
