package com.fsa.firststepapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Clasă de entitate care reprezintă o universitate în aplicație.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Universities")
public class University implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "universityId")
    private Long universityId;

    @Column(name = "name")
    private String name;

    @Column(name = "img")
    private String img;

    @OneToMany(mappedBy = "university")
    private List<Faculty> faculties;

    @OneToMany(mappedBy = "university")
    private List<Announcement> announcements;

    @OneToMany(mappedBy = "university")
    private List<User> users;
}
