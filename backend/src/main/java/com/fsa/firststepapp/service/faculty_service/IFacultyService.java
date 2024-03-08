package com.fsa.firststepapp.service.faculty_service;

import com.fsa.firststepapp.models.dto.FacultyDto;
import com.fsa.firststepapp.models.request.AddFacultyRequest;

import java.util.List;

/**
 * Interfață ce definește operațiile disponibile pentru gestionarea facultatilor în cadrul aplicației.
 */
public interface IFacultyService {

    /**
     * Obține o listă cu toate facultățile.
     *
     * @return O listă de FacultyDto care reprezintă toate facultățile.
     */
    List<FacultyDto> getAllFaculties();

    /**
     * Adaugă o facultate nouă pe baza cererii furnizate.
     *
     * @param faculty Cererea care conține informații pentru crearea unei facultăți noi.
     * @return Un FacultyDto care reprezintă facultatea nouă creată.
     */
    FacultyDto addFaculty(AddFacultyRequest faculty);

    /**
     * Actualizează o facultate existentă identificată de facultyId pe baza cererii furnizate.
     *
     * @param facultyId Identificatorul unic al facultății care urmează să fie actualizată.
     * @param faculty   Cererea care conține informații actualizate pentru facultate.
     * @return Un FacultyDto care reprezintă facultatea actualizată.
     */
    FacultyDto updateFaculty(String facultyId, AddFacultyRequest faculty);

    /**
     * Șterge o facultate pe baza facultyId-ului furnizat.
     *
     * @param facultyId Identificatorul unic al facultății care urmează să fie ștearsă.
     */
    void deleteFaculty(String facultyId);
}
