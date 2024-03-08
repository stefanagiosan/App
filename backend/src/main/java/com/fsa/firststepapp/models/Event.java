package com.fsa.firststepapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Clasă de entitate care reprezintă un eveniment în aplicație.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Events")
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="eventId")
    private Long eventId;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="participants")
    private Long participants;

    @Column(name="eventDate")
    private Date eventDate;

    @ManyToOne()
    @JoinColumn(name = "location", nullable = false)
    private Location location;
}
