package com.fsa.firststepapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Clasă de entitate care reprezintă o facultate în cadrul unei universități în aplicație.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Faculties")
public class Faculty implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="facultyId")
    private Long facultyId;

    @Column(name="name")
    private String name;

    @ManyToOne()
    @JoinColumn(name="university", nullable = false)
    private University university;

    @OneToMany(mappedBy = "faculty")
    private List<User> users;

    @OneToMany(mappedBy = "faculty")
    private List<Announcement> announcements;
}
