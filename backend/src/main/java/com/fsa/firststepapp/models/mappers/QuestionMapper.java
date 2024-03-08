package com.fsa.firststepapp.models.mappers;

import com.fsa.firststepapp.models.Question;
import com.fsa.firststepapp.models.dto.QuestionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Clasa care se ocupă de conversia dintre Question și QuestionDto.
 */
@Component
public class QuestionMapper {
    private final AnswerMapper answerMapper;

    @Autowired
    public QuestionMapper(AnswerMapper answerMapper){
        this.answerMapper = answerMapper;
    }

    /**
     * Converteste un obiect Question într-un obiect QuestionDto.
     * @param question Obiectul Question de conversie.
     * @return Obiectul QuestionDto rezultat.
     */
    public QuestionDto convertModelToDto(Question question) {
        QuestionDto questionDto = new QuestionDto();

        questionDto.setQuestionId(question.getQuestionId());
        questionDto.setText(question.getText());
        questionDto.setQuestionDate(question.getQuestionDate());
        questionDto.setCategory(question.getCategory());
        questionDto.setUser(question.getUser().getName());
        questionDto.setAnswers(answerMapper.convertModelListToDtoList(question.getAnswers()));

        return questionDto;
    }

    /**
     * Converteste o listă de obiecte Question într-o listă de obiecte QuestionDto.
     * @param questions Lista de obiecte Question de conversie.
     * @return Lista de obiecte QuestionDto rezultate.
     */
    public List<QuestionDto> convertModelListToDtoList(List<Question> questions) {
        List<QuestionDto> questionDtos = new ArrayList<>();

        for(Question question: questions) {
            questionDtos.add(convertModelToDto(question));
        }

        return questionDtos;
    }
}
