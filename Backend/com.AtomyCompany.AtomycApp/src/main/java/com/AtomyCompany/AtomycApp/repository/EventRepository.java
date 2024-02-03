package com.AtomyCompany.AtomycApp.repository;

import com.AtomyCompany.AtomycApp.model.Event;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
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
}
