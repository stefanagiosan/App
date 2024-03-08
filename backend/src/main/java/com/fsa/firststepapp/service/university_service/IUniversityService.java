package com.fsa.firststepapp.service.university_service;

import com.fsa.firststepapp.models.dto.UniversityDto;
import com.fsa.firststepapp.models.request.AddUniversityRequest;

import java.util.List;

/**
 * Interfață ce definește operațiile disponibile pentru gestionarea universitatilor în cadrul aplicației.
 */
public interface IUniversityService {

    /**
     * Obține toate universitățile disponibile.
     *
     * @return Lista de obiecte UniversityDto reprezentând universitățile.
     */
    List<UniversityDto> getAllUniversities();


    /**
     * Adaugă o nouă universitate.
     *
     * @param university Obiectul AddUniversityRequest care conține informațiile despre noua universitate.
     * @return Obiectul UniversityDto reprezentând universitatea adăugată.
     */
    UniversityDto addUniversity(AddUniversityRequest university);

    /**
     * Actualizează informațiile unei universități existente.
     *
     * @param universityId         Identificatorul unic al universității care urmează să fie actualizată.
     * @param university Obiectul AddUniversityRequest care conține noile informații despre universitate.
     * @return Obiectul UniversityDto reprezentând universitatea actualizată.
     */
    UniversityDto updateUniversity(String universityId, AddUniversityRequest university);

    /**
     * Șterge o universitate existentă.
     *
     * @param universityId Identificatorul unic al universității care urmează să fie ștearsă.
     */
    void deleteUniversity(String universityId);
}
