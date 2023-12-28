package com.AtomyCompany.AtomycApp.repository;

import com.AtomyCompany.AtomycApp.model.Event;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByEventName(String name);

    Event findByEventDate(Date date);

    Event findByRegistEvent(Date date);
}