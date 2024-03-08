package com.fsa.firststepapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Clasa care reprezintă o entitate Hibernate pentru tabela "Answers".
 */
@Entity
@Table(name="Answers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answerId")
    private Long answerId;

    @Column(name = "text")
    private String text;

    @Column(name = "answerDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date answerDate;

    @ManyToOne
    @JoinColumn(name = "question", nullable = false)
    private Question question;

    @ManyToOne()
    @JoinColumn(name = "posterId", nullable = false)
    private User user;
}
