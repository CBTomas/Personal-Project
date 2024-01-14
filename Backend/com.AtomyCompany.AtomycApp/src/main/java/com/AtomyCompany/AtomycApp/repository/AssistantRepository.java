package com.AtomyCompany.AtomycApp.repository;
import com.AtomyCompany.AtomycApp.model.Assistant;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface AssistantRepository extends JpaRepository<Assistant, Long> {

    List<Assistant> findByAssistantName(String name);

    Assistant findByAssistantPhone(int phone);

    Assistant findByAssistantEmail(String email);

    Assistant findByAssistantAddress(String address);

    List<Assistant> findByAssistantAge(int age);

    List<Assistant> findByAssistantRegist(Date date);

}
