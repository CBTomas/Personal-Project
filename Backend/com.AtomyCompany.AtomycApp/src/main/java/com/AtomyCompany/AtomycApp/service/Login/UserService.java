package com.AtomyCompany.AtomycApp.service.Login;

import com.AtomyCompany.AtomycApp.DTO.Login.UserDTO;
import jakarta.transaction.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
public interface UserService {

    UserDTO saveUser(UserDTO userDTO);

    UserDTO getUserById(Long id);

    UserDTO getUSerByName(String name);

    UserDTO getUserByEmail(String email);

    List<UserDTO> getUserByRegist(Date date);

    void deleteUser(Long id);

}
