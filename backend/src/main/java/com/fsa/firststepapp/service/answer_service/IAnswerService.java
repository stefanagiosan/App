package com.fsa.firststepapp.service.answer_service;

import com.fsa.firststepapp.models.dto.AnswerDto;
import com.fsa.firststepapp.models.request.AddAnswerRequest;

import java.util.List;

/**
 * Interfață ce definește operațiile disponibile pentru gestionarea răspunsurilor la întrebări în cadrul aplicației.
 */
public interface IAnswerService {

    /**
     * Obține toate răspunsurile disponibile.
     *
     * @return Lista de obiecte AnswerDto care reprezintă răspunsurile la întrebări.
     */
    List<AnswerDto> getAllAnswers();

    /**
     * Adaugă un nou răspuns la o întrebare în sistem.
     *
     * @param answerRequest Obiectul AddAnswerRequest ce conține informațiile pentru noul răspuns.
     * @return Obiect AnswerDto care reprezintă răspunsul adăugat.
     */
    AnswerDto addAnswer(AddAnswerRequest answerRequest);
}
