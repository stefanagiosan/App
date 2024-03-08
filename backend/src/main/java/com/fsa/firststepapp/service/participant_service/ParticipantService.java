package com.fsa.firststepapp.service.participant_service;

import com.fsa.firststepapp.models.Event;
import com.fsa.firststepapp.models.Participant;
import com.fsa.firststepapp.models.User;
import com.fsa.firststepapp.models.dto.ParticipantDto;
import com.fsa.firststepapp.models.exception.models.EntityNotFoundException;
import com.fsa.firststepapp.models.mappers.ParticipantMapper;
import com.fsa.firststepapp.models.request.AddParticipantRequest;
import com.fsa.firststepapp.repository.EventRepository;
import com.fsa.firststepapp.repository.ParticipantRepository;
import com.fsa.firststepapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService implements IParticipantService {
    private final ParticipantRepository participantRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final ParticipantMapper participantMapper;

    @Autowired
    public ParticipantService(ParticipantRepository participantRepository, EventRepository eventRepository,
                              UserRepository userRepository, ParticipantMapper participantMapper) {
        this.participantRepository = participantRepository;
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
        this.participantMapper = participantMapper;
    }

    @Override
    public ParticipantDto addParticipant(AddParticipantRequest addParticipantRequest) {
        User user = userRepository.findByEmail(addParticipantRequest.getUser()).orElseThrow();
        Event event = eventRepository.findByEventId(addParticipantRequest.getEventId()).orElseThrow();
        Participant participant = new Participant();
        participant.setUserEmail(addParticipantRequest.getUser());
        participant.setEventId(addParticipantRequest.getEventId());
        return participantMapper.convertModelToDto(participantRepository.save(participant));
    }

    @Override
    public List<ParticipantDto> getAllParticipants() {
        List<Participant> participants = (List<Participant>) participantRepository.findAll();

        if(participants.isEmpty()) {
            throw new EntityNotFoundException("Participants Not Found!!");
        }

        return participantMapper.convertModelListToDtoList(participants);
    }
}
