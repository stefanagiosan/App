package com.fsa.firststepapp.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * Obiectul de transfer de date (DTO) pentru întrebări.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {
    private Long questionId;
    private String text;
    private String user;
    private Date questionDate;
    private String category;
    private List<AnswerDto> answers;
}
