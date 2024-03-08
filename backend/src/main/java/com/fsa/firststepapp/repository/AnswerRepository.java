package com.fsa.firststepapp.repository;

import com.fsa.firststepapp.models.Answer;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository pentru manipularea datelor entității Answer.
 */
public interface AnswerRepository extends CrudRepository<Answer, Long> {
}
