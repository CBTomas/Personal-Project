package com.AtomyCompany.AtomycApp.repository;
import com.AtomyCompany.AtomycApp.model.Assistant;
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
public interface AssistantRepository extends JpaRepository<Assistant, Long> {

    List<Assistant> findByAssistantName(String name);

    Assistant findByAssistantPhone(String phone);

    Assistant findByAssistantEmail(String email);

    Assistant findByAssistantAddress(String address);

    List<Assistant> findByAssistantAge(int age);

    List<Assistant> findByRegistrationDate(LocalDate date);

    @Query("Select as.eventsAssist from Assistant as where as.idAssistant = :idAss")
    public List<Event> getEventByAssistant(@Param("idAss") Long idAss);

}
