package com.fsa.firststepapp.repository;

import com.fsa.firststepapp.models.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository pentru manipularea datelor entității Location.
 */
@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {

    /**
     * Găsește o locație după ID-ul său.
     *
     * @param locationId ID-ul locației căutate.
     * @return O opțiune care conține locația găsită sau null dacă nu există.
     */
    Optional<Location> findByLocationId(Long locationId);

    /**
     * Găsește o locație după nume.
     *
     * @param name Numele locației căutate.
     * @return O opțiune care conține locația găsită sau null dacă nu există.
     */
    Optional<Location> findByName(String name);
}
