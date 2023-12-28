package com.AtomyCompany.AtomycApp.repository.LogIn;

import com.AtomyCompany.AtomycApp.model.LogIn.Users;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByUserName(String name);

    Users findByUserEmail(String email);
}
