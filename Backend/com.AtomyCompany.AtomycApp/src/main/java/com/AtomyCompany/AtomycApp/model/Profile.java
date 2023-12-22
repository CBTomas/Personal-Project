package com.AtomyCompany.AtomycApp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "Profile")
public class Profile {

    // Parameters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idProfile;

    @Column
    String nameProfile;

    //Relations
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "userProfile")
    @ToString.Exclude
    private List<Users> users = new ArrayList<>();

    // Functions
    @Override
    public String toString() {
        return "Profile{" +
                "idProfile=" + idProfile +
                ", nameProfile='" + nameProfile + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(idProfile, profile.idProfile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProfile);
    }
}
