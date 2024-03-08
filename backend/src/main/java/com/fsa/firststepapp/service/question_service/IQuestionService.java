package com.fsa.firststepapp.service.question_service;

import com.fsa.firststepapp.models.dto.QuestionDto;
import com.fsa.firststepapp.models.request.AddQuestionRequest;

import java.util.List;

/**
 * Interfață ce definește operațiile disponibile pentru gestionarea întrebărilor în cadrul aplicației.
 */
public interface IQuestionService {

    /**
     * Obține toate întrebările disponibile.
     *
     * @return Lista de obiecte QuestionDto reprezentând întrebările.
     */
    List<QuestionDto> getAllQuestions();

    /**
     * Adaugă o nouă întrebare.
     *
     * @param addQuestionRequest Obiectul AddQuestionRequest care conține informațiile despre noua întrebare.
     * @return Obiectul QuestionDto reprezentând întrebarea adăugată.
     */
    QuestionDto addQuestion(AddQuestionRequest addQuestionRequest);
}