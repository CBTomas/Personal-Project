package com.AtomyCompany.AtomycApp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.Objects;

@Data
@Entity
@Table(name = "Users")
public class Users {

    // Parameters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userId;

    @Column
    String userName;

    @Column
    String userEmail;

    @Column
    String userPassword;

    @Column
    Date registUser;

    // Relations
    @ManyToOne
    @JoinColumn(name = "users")
    @ToString.Exclude
    private Profile userProfile;


    // Fuctions
    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", registUser=" + registUser +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(userId, users.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
