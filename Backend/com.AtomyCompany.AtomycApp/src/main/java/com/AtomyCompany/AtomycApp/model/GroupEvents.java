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
@Table(name = "GroupEvents")
public class GroupEvents {

    // Parameters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long groupEventsID;

    @Column
    String groupName;

    @Column
    Date registGroup;

    // Relations
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "groupEvents")
    @ToString.Exclude
    private List<Event> events = new ArrayList<>();

    // Functions
    @Override
    public String toString() {
        return "GroupEvents{" +
                "groupEvents=" + groupEventsID +
                ", groupName='" + groupName + '\'' +
                ", registGroup=" + registGroup +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupEvents that = (GroupEvents) o;
        return Objects.equals(groupEventsID, that.groupEventsID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupEventsID);
    }
}
