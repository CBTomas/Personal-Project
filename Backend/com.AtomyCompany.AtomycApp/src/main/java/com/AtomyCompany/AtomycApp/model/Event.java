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
@Table(name = "Event")
public class Event {

    // Parameters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEvent;

    @Column
    String eventName;

    @Column
    Date eventDate;

    @Column
    int eventPrice;

    @Column
    int assistantPrice;

    @Column
    Date registEvent;

    // Relations
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "eventsAssist",
            joinColumns = @JoinColumn(name = "idAssistant"),
            inverseJoinColumns = @JoinColumn(name = "idEvent"))
    @ToString.Exclude
    private List<Assistant> assistantsEvent = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "eventContracting")
    @ToString.Exclude
    private List<Contracting> contractions = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "events")
    @ToString.Exclude
    private GroupEvents groupEvents;

    // Functions
    @Override
    public String toString() {
        return "Event{" +
                "idEvent=" + idEvent +
                ", eventName='" + eventName + '\'' +
                ", eventDate=" + eventDate +
                ", eventPrice=" + eventPrice +
                ", assistantPrice=" + assistantPrice +
                ", registEvent=" + registEvent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(idEvent, event.idEvent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEvent);
    }
}
