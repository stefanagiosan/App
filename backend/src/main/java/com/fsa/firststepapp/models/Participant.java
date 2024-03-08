package com.fsa.firststepapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Clasă de entitate care reprezintă participanții la evenimente în aplicație.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Participants")
public class Participant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="participantId")
    private Long participantId;

    @Column(name="userEmail")
    private String userEmail;

    @Column(name="eventId")
    private Long eventId;
}
