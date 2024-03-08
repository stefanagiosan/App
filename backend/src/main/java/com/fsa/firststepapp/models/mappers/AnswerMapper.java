package com.fsa.firststepapp.models.mappers;

import com.fsa.firststepapp.models.Answer;
import com.fsa.firststepapp.models.dto.AnswerDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Clasa care se ocupă de conversia dintre Answer și AnswerDto.
 */
@Component
public class AnswerMapper {
    public AnswerMapper() {
    }

    /**
     * Converteste un obiect Answer într-un obiect AnswerDto.
     *
     * @param answer Obiectul Answer de conversie.
     * @return Obiectul AnswerDto rezultat.
     */
    public AnswerDto convertModelToDto(Answer answer) {
        AnswerDto answerDto = new AnswerDto();

        answerDto.setAnswerId(answer.getAnswerId());
        answerDto.setAnswerDate(answer.getAnswerDate());
        answerDto.setText(answer.getText());
        answerDto.setUser(answer.getUser().getName());
        answerDto.setQuestion(answer.getQuestion().getQuestionId());

        return answerDto;
    }

    /**
     * Converteste o listă de obiecte Answer într-o listă de obiecte AnswerDto.
     *
     * @param answers Lista de obiecte Answer de conversie.
     * @return Lista de obiecte AnswerDto rezultate.
     */
    public List<AnswerDto> convertModelListToDtoList(List<Answer> answers) {
        List<AnswerDto> answerDtos = new ArrayList<>();

        for(Answer answer: answers) {
            answerDtos.add(convertModelToDto(answer));
        }

        return answerDtos;
    }
}
