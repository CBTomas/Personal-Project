package com.AtomyCompany.AtomycApp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Objects;

@Data
@Entity
@Table(name="Configuration")
public class Configuration {

    // Parameters
    @Id
    String name;

    @Column
    String parameter;

    // Functions
    @Override
    public String toString() {
        return "Configuration{" +
                "name='" + name + '\'' +
                ", parameter='" + parameter + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Configuration that = (Configuration) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
