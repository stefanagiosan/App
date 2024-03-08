package com.fsa.firststepapp.service.question_service;

import com.fsa.firststepapp.models.Question;
import com.fsa.firststepapp.models.User;
import com.fsa.firststepapp.models.dto.QuestionDto;
import com.fsa.firststepapp.models.exception.models.EntityNotFoundException;
import com.fsa.firststepapp.models.mappers.QuestionMapper;
import com.fsa.firststepapp.models.request.AddQuestionRequest;
import com.fsa.firststepapp.repository.QuestionRepository;
import com.fsa.firststepapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService implements IQuestionService{
    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;
    private final UserRepository userRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository, QuestionMapper questionMapper, UserRepository userRepository){
        this.questionRepository=questionRepository;
        this.questionMapper=questionMapper;
        this.userRepository = userRepository;
    }

    @Override
    public List<QuestionDto> getAllQuestions() {
        List<Question> questions = (List<Question>) questionRepository.findAll();

        if(questions.isEmpty()) {
            throw new EntityNotFoundException("Questions Not Found!!");
        }

        return questionMapper.convertModelListToDtoList(questions);
    }

    @Override
    public QuestionDto addQuestion(AddQuestionRequest addQuestionRequest) {
        Optional<User> user = userRepository.findByEmail(addQuestionRequest.getUser());

        if (user.isPresent()) {
            Question question = new Question();
            question.setText(addQuestionRequest.getText());
            question.setQuestionDate(new Date());
            question.setCategory(addQuestionRequest.getCategory());
            question.setUser(user.get());
            question.setAnswers(new ArrayList<>());

            return questionMapper.convertModelToDto(questionRepository.save(question));
        } else {
            throw new EntityNotFoundException("User not found with email: " + addQuestionRequest.getUser());
        }
    }
}
