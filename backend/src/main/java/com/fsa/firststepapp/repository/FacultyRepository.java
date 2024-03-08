package com.fsa.firststepapp.repository;

import com.fsa.firststepapp.models.Faculty;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Repository pentru manipularea datelor entității Faculty.
 */
public interface FacultyRepository extends CrudRepository<Faculty, Long> {

    /**
     * Găsește o facultate după nume.
     *
     * @param name Numele facultății căutate.
     * @return O opțiune care conține facultatea găsită sau null dacă nu există.
     */
    Optional<Faculty> findFacultyByName(String name);

    /**
     * Găsește o facultate după ID-ul său.
     *
     * @param facultyId ID-ul facultății căutate.
     * @return O opțiune care conține facultatea găsită sau null dacă nu există.
     */
    Optional<Faculty> findByFacultyId(Long facultyId);
}
