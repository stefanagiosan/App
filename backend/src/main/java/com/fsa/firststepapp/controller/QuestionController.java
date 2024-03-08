package com.fsa.firststepapp.controller;

import com.fsa.firststepapp.models.dto.QuestionDto;
import com.fsa.firststepapp.models.request.AddQuestionRequest;
import com.fsa.firststepapp.service.question_service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlerul pentru gestionarea întrebărilor.
 */
@RestController
@CrossOrigin(origins="http://localhost:8100", allowedHeaders = "*")
@RequestMapping("/api/questions")
public class QuestionController {
    private final IQuestionService questionService;

    @Autowired
    public QuestionController(IQuestionService questionService) { this.questionService = questionService;}

    /**
     * Endpoint pentru obținerea tuturor întrebărilor.
     *
     * @return Lista de obiecte QuestionDto.
     */
    @GetMapping("")
    public List<QuestionDto> getAllAnswers() {
        return questionService.getAllQuestions();
    }

    /**
     * Endpoint pentru adăugarea unei întrebări.
     *
     * @param addQuestionRequest Obiectul de tip AddQuestionRequest care conține informațiile necesare pentru adăugarea unei întrebări.
     * @return Obiectul QuestionDto reprezentând întrebarea adăugată.
     */
    @PostMapping("/addQuestion")
    public QuestionDto addQuestion(@RequestBody AddQuestionRequest addQuestionRequest) {return questionService.addQuestion(addQuestionRequest);}
}
