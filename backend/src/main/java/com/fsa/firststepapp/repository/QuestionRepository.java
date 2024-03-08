package com.fsa.firststepapp.repository;

import com.fsa.firststepapp.models.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Repository pentru manipularea datelor entității Question.
 */
public interface QuestionRepository extends CrudRepository<Question, Long> {

     /**
      * Găsește o întrebare după id-ul acesteia.
      *
      * @param questionId Id-ul întrebării căutate.
      * @return O întrebare opțională (presupune că întrebarea există sau nu).
      */
     Optional<Question> findByQuestionId(Long questionId);
}
