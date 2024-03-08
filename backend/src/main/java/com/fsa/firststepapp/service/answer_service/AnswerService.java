package com.fsa.firststepapp.service.answer_service;

import com.fsa.firststepapp.models.Answer;
import com.fsa.firststepapp.models.Question;
import com.fsa.firststepapp.models.User;
import com.fsa.firststepapp.models.dto.AnswerDto;
import com.fsa.firststepapp.models.exception.models.EntityNotFoundException;
import com.fsa.firststepapp.models.mappers.AnswerMapper;
import com.fsa.firststepapp.models.request.AddAnswerRequest;
import com.fsa.firststepapp.repository.AnswerRepository;
import com.fsa.firststepapp.repository.QuestionRepository;
import com.fsa.firststepapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AnswerService implements IAnswerService{
    private final AnswerRepository answerRepository;
    private final AnswerMapper answerMapper;
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository, AnswerMapper answerMapper, UserRepository userRepo, QuestionRepository questionRepository){
        this.answerMapper = answerMapper;
        this.answerRepository = answerRepository;
        this.userRepository = userRepo;
        this.questionRepository = questionRepository;
    }

    @Override
    public List<AnswerDto> getAllAnswers() {
        List<Answer> answers = (List<Answer>) answerRepository.findAll();

        if(answers.isEmpty()) {
            throw new EntityNotFoundException("Answers Not Found!!");
        }

        return answerMapper.convertModelListToDtoList(answers);
    }

    @Override
    public AnswerDto addAnswer(AddAnswerRequest addAnswerRequest) {
        Optional<User> optionalUser = userRepository.findByEmail(addAnswerRequest.getUser());
        Question question = questionRepository.findByQuestionId(addAnswerRequest.getQuestion()).orElseThrow();

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Answer answer = new Answer();
            answer.setText(addAnswerRequest.getText());
            answer.setAnswerDate(new Date());
            answer.setQuestion(question);
            answer.setUser(user);

            return answerMapper.convertModelToDto(answerRepository.save(answer));
        } else {
            throw new EntityNotFoundException("User or Question not found with provided information.");
        }
    }
}
