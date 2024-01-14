package com.AtomyCompany.AtomycApp.repository.LogIn;

import com.AtomyCompany.AtomycApp.model.LogIn.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByUserName(String name);

    Users findByUserEmail(String email);

    List<Users> findByRegistUser(Date date);
}
