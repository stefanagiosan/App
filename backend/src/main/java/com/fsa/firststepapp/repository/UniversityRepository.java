package com.fsa.firststepapp.repository;

import com.fsa.firststepapp.models.University;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository pentru manipularea datelor entității University.
 */
@Repository
public interface UniversityRepository extends CrudRepository<University, Long> {

     /**
      * Găsește o universitate după numele acesteia.
      *
      * @param name Numele universității căutate.
      * @return O universitate opțională (presupune că universitatea există sau nu).
      */
     Optional<University> findUniversityByName(String name);

     /**
      * Găsește o universitate după id-ul acesteia.
      *
      * @param universityId Id-ul universității căutate.
      * @return O universitate opțională (presupune că universitatea există sau nu).
      */
     Optional<University> findByUniversityId(Long universityId);
}
