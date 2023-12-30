package com.AtomyCompany.AtomycApp.DTO.Login;

import com.AtomyCompany.AtomycApp.model.LogIn.Users;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
public class UsersDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 4L;

    private Long userID;
    private String userEmail;
    private String userPassword;
    private Date registUser;

    public static UsersDTO convertToDTO(Users users){

        UsersDTO userDTO = new UsersDTO();

        userDTO.setUserID(users.getUserId());
        userDTO.setUserEmail(users.getUserEmail());
        userDTO.setUserPassword(users.getUserPassword());
        userDTO.setRegistUser(users.getRegistUser());

        return userDTO;
    }

    public static Users convertToEntity(UsersDTO usersDTO){

        Users user = new Users();

        user.setUserId(usersDTO.getUserID());
        user.setUserEmail(usersDTO.getUserEmail());
        user.setUserPassword(usersDTO.getUserPassword());
        user.setRegistUser(usersDTO.getRegistUser());

        return user;
    }
}
