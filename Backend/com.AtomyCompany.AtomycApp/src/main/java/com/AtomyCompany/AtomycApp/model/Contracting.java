package com.AtomyCompany.AtomycApp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.Objects;

@Data
@Entity
@Table(name = "Contracting")
public class Contracting {

    // Parameters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idContracting;

    @Column
    String contractingName;

    @Column
    String description;

    @Column
    int price;

    @Column
    Date registContracting;

    // Relations
    @ManyToOne
    @JoinColumn(name = "contractions")
    @ToString.Exclude
    Event eventContracting;

    // Functions
    @Override
    public String toString() {
        return "Contracting{" +
                "idContracting=" + idContracting +
                ", contractingName='" + contractingName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", registContracting=" + registContracting +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contracting that = (Contracting) o;
        return Objects.equals(idContracting, that.idContracting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idContracting);
    }
}
