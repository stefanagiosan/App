package com.fsa.firststepapp.repository;

import com.fsa.firststepapp.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository pentru manipularea datelor entității Event.
 */
@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

    /**
     * Găsește un eveniment după ID-ul său.
     *
     * @param eventId ID-ul evenimentului căutat.
     * @return O opțiune care conține evenimentul găsit sau null dacă nu există.
     */
    Optional<Event> findByEventId(Long eventId) ;
}
