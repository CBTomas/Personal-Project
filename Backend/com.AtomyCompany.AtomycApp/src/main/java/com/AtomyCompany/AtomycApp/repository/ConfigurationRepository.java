package com.AtomyCompany.AtomycApp.repository;

import com.AtomyCompany.AtomycApp.model.Configuration;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ConfigurationRepository extends JpaRepository<Configuration, String>{

}
