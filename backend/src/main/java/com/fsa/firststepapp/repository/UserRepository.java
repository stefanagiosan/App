package com.fsa.firststepapp.repository;

import com.fsa.firststepapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository pentru manipularea datelor entității User.
 */
public interface UserRepository extends JpaRepository<User, UUID> {

    /**
     * Găsește un utilizator după adresa de email.
     *
     * @param email Adresa de email a utilizatorului căutat.
     * @return Un utilizator opțional (presupune că utilizatorul există sau nu).
     */
    Optional<User> findByEmail(String email);
}
