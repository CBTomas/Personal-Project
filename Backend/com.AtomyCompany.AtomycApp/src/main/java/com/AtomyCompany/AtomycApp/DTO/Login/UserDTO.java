package com.AtomyCompany.AtomycApp.DTO.Login;

import com.AtomyCompany.AtomycApp.model.LogIn.Users;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
public class UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 4L;

    private Long userID;
    private String userEmail;
    private String userPassword;
    private Date registUser;

    public static UserDTO convertToDTO(Users users){

        UserDTO userDTO = new UserDTO();

        userDTO.setUserID(users.getUserId());
        userDTO.setUserEmail(users.getUserEmail());
        userDTO.setUserPassword(users.getUserPassword());
        userDTO.setRegistUser(users.getRegistUser());

        return userDTO;
    }

    public static Users convertToEntity(UserDTO userDTO){

        Users user = new Users();

        user.setUserId(userDTO.getUserID());
        user.setUserEmail(userDTO.getUserEmail());
        user.setUserPassword(userDTO.getUserPassword());
        user.setRegistUser(userDTO.getRegistUser());

        return user;
    }
}
