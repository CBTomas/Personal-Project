package com.AtomyCompany.AtomycApp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Organization")
public class Organization {

    // Parameters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String name;

    @Column
    String address;

    @Column
    String city;

    @Column
    int members;

    // Functions
    @Override
    public String toString() {
        return "Organizaton{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", City='" + city + '\'' +
                ", members=" + members +
                '}';
    }
}
