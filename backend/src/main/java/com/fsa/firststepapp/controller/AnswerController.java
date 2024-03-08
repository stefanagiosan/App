package com.fsa.firststepapp.controller;

import com.fsa.firststepapp.models.dto.AnswerDto;
import com.fsa.firststepapp.models.request.AddAnswerRequest;
import com.fsa.firststepapp.service.answer_service.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlerul pentru gestionarea răspunsurilor.
 */
@RestController
@CrossOrigin(origins="http://localhost:8100", allowedHeaders = "*")
@RequestMapping("/api/answers")
public class AnswerController {
    private final IAnswerService answerService;

    @Autowired
    public AnswerController(IAnswerService answerService) { this.answerService = answerService;}

    /**
     * Endpoint pentru obținerea tuturor răspunsurilor.
     *
     * @return Lista de obiecte AnswerDto.
     */
    @GetMapping("")
    public List<AnswerDto> getAllAnswers() {
        return answerService.getAllAnswers();
    }

    /**
     * Endpoint pentru adăugarea unui răspuns nou.
     *
     * @param addAnswerRequest Obiectul de tip AddAnswerRequest care conține informațiile necesare pentru adăugarea răspunsului.
     * @return Obiectul AnswerDto reprezentând răspunsul adăugat.
     */
    @PostMapping("/addAnswer")
    public AnswerDto addAnswer(@RequestBody AddAnswerRequest addAnswerRequest){return answerService.addAnswer(addAnswerRequest);}
}