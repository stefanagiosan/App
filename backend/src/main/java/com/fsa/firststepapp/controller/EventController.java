package com.fsa.firststepapp.controller;

import com.fsa.firststepapp.models.dto.EventDto;
import com.fsa.firststepapp.models.request.AddParticipantToEventRequest;
import com.fsa.firststepapp.service.event_service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlerul pentru gestionarea evenimentelor.
 */
@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
@RequestMapping("/api/events")
public class EventController {
    private final IEventService eventService;

    @Autowired
    public EventController(IEventService eventService) {
        this.eventService = eventService;
    }

    /**
     * Endpoint pentru obținerea tuturor evenimentelor.
     *
     * @return Lista de obiecte EventDto.
     */
    @GetMapping("")
    public List<EventDto> getAllEvents() {
        return eventService.getAllEvents();
    }

    /**
     * Endpoint pentru adăugarea unui participant la un eveniment.
     *
     * @param addParticipantToEventRequest Obiectul de tip AddParticipantToEventRequest care conține informațiile necesare pentru adăugarea participantului la eveniment.
     * @return Obiectul EventDto reprezentând evenimentul actualizat.
     */
    @PatchMapping("/addParticipant")
    public EventDto addParticipantToEvent(@RequestBody AddParticipantToEventRequest addParticipantToEventRequest){
        return eventService.addParticipantToEvent(addParticipantToEventRequest);
    }
}
