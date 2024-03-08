package com.fsa.firststepapp.service.location_service;

import com.fsa.firststepapp.models.dto.LocationDto;
import com.fsa.firststepapp.models.request.AddLocationRequest;

import java.util.List;

/**
 * Interfață ce definește operațiile disponibile pentru gestionarea locatiilor în cadrul aplicației.
 */
public interface ILocationService {

    /**
     * Obține toate locațiile disponibile.
     *
     * @return Lista de obiecte LocationDto reprezentând locațiile.
     */
    List<LocationDto> getAllLocations();

    /**
     * Adaugă o nouă locație.
     *
     * @param location Obiectul AddLocationRequest care conține informațiile despre noua locație.
     * @return Obiectul LocationDto reprezentând locația adăugată.
     */
    LocationDto addLocation(AddLocationRequest location);

    /**
     * Actualizează informațiile unei locații existente.
     *
     * @param location    Obiectul AddLocationRequest care conține noile informații despre locație.
     * @param locationId  Identificatorul unic al locației care va fi actualizată.
     * @return Obiectul LocationDto reprezentând locația actualizată.
     */
    LocationDto updateLocation(AddLocationRequest location, String locationId);

    /**
     * Șterge o locație existentă.
     *
     * @param locationId Identificatorul unic al locației care va fi ștearsă.
     */
    void deleteLocation(String locationId);
}
