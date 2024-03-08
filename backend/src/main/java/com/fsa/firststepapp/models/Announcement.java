package com.fsa.firststepapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Clasa care reprezintă o entitate Hibernate pentru tabela "Announcements".
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Announcements")
public class Announcement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="announcementId")
    private Long announcementId;

    @Column(name="title")
    private String title;

    @Column(name="text")
    private String text;

    @Column(name="url")
    private String url;

    @ManyToOne()
    @JoinColumn(name="university")
    private University university;

    @ManyToOne()
    @JoinColumn(name="faculty")
    private Faculty faculty;
}
