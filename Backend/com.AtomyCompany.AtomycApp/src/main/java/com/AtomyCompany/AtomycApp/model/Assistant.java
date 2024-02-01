package com.AtomyCompany.AtomycApp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "Assistant")
public class Assistant {

    // Parameters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idAssistant;

    @Column(name = "name")
    String assistantName;

    @Column(name = "phone")
    int assistantPhone;

    @Column(name = "email")
    String assistantEmail;

    @Column(name = "address")
    String assistantAddress;

    @Column(name = "age")
    int assistantAge;

    @Column(name = "regist")
    Date assistantRegist;

    // Relations
    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "assistantsEvent")
    @ToString.Exclude
    private List<Event> eventsAssist = new ArrayList<>();

    // Functions
    @Override
    public String toString() {
        return "Assistant{" +
                "idAssistant=" + idAssistant +
                ", assistantName='" + assistantName + '\'' +
                ", assistantPhone=" + assistantPhone +
                ", assistantEmail='" + assistantEmail + '\'' +
                ", assistantAddress='" + assistantAddress + '\'' +
                ", assistantAge=" + assistantAge +
                ", registAssistant=" + assistantRegist +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assistant assistant = (Assistant) o;
        return Objects.equals(idAssistant, assistant.idAssistant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAssistant);
    }
}
