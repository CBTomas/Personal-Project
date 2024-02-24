package com.AtomyCompany.AtomycApp.repository;

import com.AtomyCompany.AtomycApp.model.Contracting;
import com.AtomyCompany.AtomycApp.model.Event;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByEventName(String name);

    List<Event> findByEventDate(LocalDate date);

    List<Event> findByEventPrice(int price);

    List<Event> findByRegistrationDate(LocalDate date);

    @Query("Select ev.contractions from Event ev where ev.idEvent = :idEv")
    public List<Contracting> getContractingByEvent(@Param("idEv") Long idEv);

}
