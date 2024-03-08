package com.fsa.firststepapp.service.event_service;

import com.fsa.firststepapp.models.Event;
import com.fsa.firststepapp.models.Location;
import com.fsa.firststepapp.models.dto.EventDto;
import com.fsa.firststepapp.models.exception.models.EntityNotFoundException;
import com.fsa.firststepapp.models.mappers.EventMapper;
import com.fsa.firststepapp.models.request.AddEventRequest;
import com.fsa.firststepapp.models.request.AddParticipantToEventRequest;
import com.fsa.firststepapp.repository.EventRepository;
import com.fsa.firststepapp.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService implements IEventService {
    private final EventRepository eventRepository;
    private final LocationRepository locationRepository;
    private final EventMapper eventMapper;

    @Autowired
    public EventService(EventRepository eventRepository, LocationRepository locationRepository, EventMapper eventMapper) {
        this.eventRepository = eventRepository;
        this.locationRepository = locationRepository;
        this.eventMapper = eventMapper;
    }

    @Override
    public List<EventDto> getAllEvents() {
        List<Event> events = (List<Event>) eventRepository.findAll();

        if (events.isEmpty()) {
            throw new EntityNotFoundException("Events not found!");
        }

        return eventMapper.convertModelListToDtoList(events);
    }

    @Override
    public EventDto addParticipantToEvent(AddParticipantToEventRequest addParticipantToEventRequest) {
        Event event = eventRepository.findByEventId(addParticipantToEventRequest.getEventId()).orElseThrow();
        event.setParticipants(addParticipantToEventRequest.getParticipants());
        Event eventUpdated = eventRepository.save(event);
        return eventMapper.convertModelToDto(eventUpdated);
    }

    @Override
    public EventDto addEvent(AddEventRequest event) {
        Event eventToAdd = new Event();
        Location location = locationRepository.findByName(event.getLocationName()).orElseThrow();

        eventToAdd.setName(event.getName());
        eventToAdd.setDescription(event.getDescription());
        eventToAdd.setParticipants(event.getParticipants());
        eventToAdd.setLocation(location);
        eventToAdd.setEventDate(event.getEventDate());

        return eventMapper.convertModelToDto(eventRepository.save(eventToAdd));
    }

    @Override
    public EventDto updateEvent(String eventId, AddEventRequest event) {
        Event eventToUpdate = eventRepository.findByEventId(Long.parseLong(eventId)).orElseThrow();
        Location location = locationRepository.findByName(event.getLocationName()).orElseThrow();

        eventToUpdate.setName(event.getName());
        eventToUpdate.setDescription(event.getDescription());
        eventToUpdate.setParticipants(event.getParticipants());
        eventToUpdate.setLocation(location);
        eventToUpdate.setEventDate(event.getEventDate());

        return eventMapper.convertModelToDto(eventRepository.save(eventToUpdate));
    }

    @Override
    public void deleteEvent(String eventId) {
        Event event = eventRepository.findByEventId(Long.parseLong(eventId)).orElseThrow();
        eventRepository.delete(event);
    }
}
