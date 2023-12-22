package com.AtomyCompany.AtomycApp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Organization")
public class Organization {

    // Parameters
    @Id
    String name;

    @Column
    String address;

    @Column
    String City;

    @Column
    long members;

    // Functions
    @Override
    public String toString() {
        return "Organizaton{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", City='" + City + '\'' +
                ", members=" + members +
                '}';
    }
}
