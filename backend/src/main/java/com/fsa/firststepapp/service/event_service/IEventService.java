package com.fsa.firststepapp.service.event_service;
import com.fsa.firststepapp.models.dto.EventDto;
import com.fsa.firststepapp.models.request.AddEventRequest;
import com.fsa.firststepapp.models.request.AddParticipantToEventRequest;

import java.util.List;

/**
 * Interfață ce definește operațiile disponibile pentru gestionarea evenimentelor în cadrul aplicației.
 */
public interface IEventService {
    /**
     * Obține o listă cu toate evenimentele.
     *
     * @return O listă de EventDto care reprezintă toate evenimentele.
     */
    List<EventDto> getAllEvents();

    /**
     * Adaugă un participant la un eveniment pe baza cererii furnizate.
     *
     * @param addParticipantToEventRequest Cererea care conține informații pentru adăugarea unui participant la un eveniment.
     * @return Un EventDto care reprezintă evenimentul actualizat după adăugarea participantului.
     */
    EventDto addParticipantToEvent(AddParticipantToEventRequest addParticipantToEventRequest);

    /**
     * Adaugă un eveniment nou pe baza cererii furnizate.
     *
     * @param event Cererea care conține informații pentru crearea unui eveniment nou.
     * @return Un EventDto care reprezintă evenimentul nou creat.
     */
    EventDto addEvent(AddEventRequest event);

    /**
     * Actualizează un eveniment existent identificat de eventId pe baza cererii furnizate.
     *
     * @param eventId Identificatorul unic al evenimentului care urmează să fie actualizat.
     * @param event   Cererea care conține informații actualizate pentru eveniment.
     * @return Un EventDto care reprezintă evenimentul actualizat.
     */
    EventDto updateEvent(String eventId, AddEventRequest event);

    /**
     * Șterge un eveniment pe baza eventId-ului furnizat.
     *
     * @param eventId Identificatorul unic al evenimentului care urmează să fie șters.
     */
    void deleteEvent(String eventId);
}
