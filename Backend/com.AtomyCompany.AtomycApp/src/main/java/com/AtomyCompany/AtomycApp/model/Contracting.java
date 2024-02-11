package com.AtomyCompany.AtomycApp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import java.time.LocalDate;
import java.util.Objects;

@Data
@Entity
@Table(name = "Contracting")
public class Contracting {

    // Parameters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idContracting;

    @Column(name = "name")
    String contractingName;

    @Column(name = "description")
    String description;

    @Column(name = "price")
    int price;

    @Column
    LocalDate registrationDate;

    // Relations
    @ManyToOne
    @JoinColumn(name = "contractions")
    @ToString.Exclude
    private Event eventContracting;

    // Functions
    @Override
    public String toString() {
        return "Contracting{" +
                "idContracting=" + idContracting +
                ", contractingName='" + contractingName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", registContracting=" + registrationDate +
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
