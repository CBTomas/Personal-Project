package com.AtomyCompany.AtomycApp.repository;

import com.AtomyCompany.AtomycApp.model.Contracting;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface ContractingRepository extends JpaRepository<Contracting, Long> {

    List<Contracting> findByContractingName(String name);

    List<Contracting> findByPrice(int price);

    List<Contracting> findByRegistrationDate(LocalDate date);
}
