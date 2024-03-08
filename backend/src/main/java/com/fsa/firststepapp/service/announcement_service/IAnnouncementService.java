package com.fsa.firststepapp.service.announcement_service;

import com.fsa.firststepapp.models.dto.AnnouncementDto;
import com.fsa.firststepapp.models.request.AddAnnouncementRequest;

import java.util.List;

/**
 * Interfață ce definește operațiile disponibile pentru gestionarea anunțurilor în cadrul aplicației.
 */
public interface IAnnouncementService {

    /**
     * Obține toate anunțurile disponibile.
     *
     * @return Lista de obiecte AnnouncementDto care reprezintă anunțurile.
     */
    List<AnnouncementDto> getAllAnnouncements();

    /**
     * Adaugă un nou anunț în sistem.
     *
     * @param announcement Obiectul AddAnnouncementRequest ce conține informațiile pentru noul anunț.
     * @return Obiect AnnouncementDto care reprezintă anunțul adăugat.
     */
    AnnouncementDto addAnnouncement(AddAnnouncementRequest announcement);

    /**
     * Actualizează informațiile unui anunț existent.
     *
     * @param announcementId Identificatorul unic al anunțului ce va fi actualizat.
     * @param announcement   Obiectul AddAnnouncementRequest ce conține noile informații pentru anunț.
     * @return Obiect AnnouncementDto care reprezintă anunțul actualizat.
     */
    AnnouncementDto updateAnnouncement(String announcementId, AddAnnouncementRequest announcement);

    /**
     * Șterge un anunț existent din sistem.
     *
     * @param announcementId Identificatorul unic al anunțului ce va fi șters.
     */
    void deleteAnnouncement(String announcementId);
}
