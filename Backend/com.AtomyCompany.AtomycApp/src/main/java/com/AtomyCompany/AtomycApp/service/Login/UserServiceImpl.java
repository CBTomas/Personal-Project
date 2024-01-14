package com.AtomyCompany.AtomycApp.service.Login;

import com.AtomyCompany.AtomycApp.DTO.Login.UserDTO;
import com.AtomyCompany.AtomycApp.model.LogIn.Users;
import com.AtomyCompany.AtomycApp.repository.LogIn.UsersRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDTO saveUser(UserDTO userDTO) {

        Users user = UserDTO.convertToEntity(userDTO);

        Users userSaved = usersRepository.save(user);

        return UserDTO.convertToDTO(userSaved);
    }

    @Override
    public UserDTO getUserById(Long id) {

        Optional<Users> user = usersRepository.findById(id);

        return user.map(UserDTO::convertToDTO).orElse(null);

    }

    @Override
    public UserDTO getUSerByName(String name) {

        Users user = usersRepository.findByUserName(name);

        return UserDTO.convertToDTO(user);
    }

    @Override
    public UserDTO getUserByEmail(String email) {

        Users user = usersRepository.findByUserEmail(email);

        return UserDTO.convertToDTO(user);
    }

    @Override
    public List<UserDTO> getUserByRegist(Date date) {

        List<Users> users = usersRepository.findByRegistUser(date);
        List<UserDTO> userDTOList = new ArrayList<>();

        for (Users users1 : users){
            userDTOList.add(UserDTO.convertToDTO(users1));
        }

        return userDTOList;
    }

    @Override
    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }
}
