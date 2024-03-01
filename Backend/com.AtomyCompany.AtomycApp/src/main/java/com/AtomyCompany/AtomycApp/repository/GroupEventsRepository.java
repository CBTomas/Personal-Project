package com.AtomyCompany.AtomycApp.repository;

import com.AtomyCompany.AtomycApp.model.Event;
import com.AtomyCompany.AtomycApp.model.GroupEvents;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface GroupEventsRepository extends JpaRepository<GroupEvents, Long> {

    List<GroupEvents> findByGroupName(String name);

    List<GroupEvents> findByRegistrationDate(LocalDate date);

    @Query("Select ge.events from GroupEvents ge where ge.groupEventsID = :idGroup")
    public List<Event> getEventsByGroupEvents(@Param("idGroup") Long idGroup);

}
