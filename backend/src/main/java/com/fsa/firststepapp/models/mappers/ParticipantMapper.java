package com.fsa.firststepapp.models.mappers;

import com.fsa.firststepapp.models.Participant;
import com.fsa.firststepapp.models.dto.ParticipantDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Clasa care se ocupă de conversia dintre Participant și ParticipantDto.
 */
@Component
public class ParticipantMapper {
    public ParticipantMapper() {
    }

    /**
     * Converteste un obiect Participant într-un obiect ParticipantDto.
     *
     * @param participant Obiectul Participant de conversie.
     * @return Obiectul ParticipantDto rezultat.
     */
    public ParticipantDto convertModelToDto(Participant participant) {
        ParticipantDto participantDto = new ParticipantDto();

        participantDto.setParticipantId(participant.getParticipantId());
        participantDto.setUserEmail(participant.getUserEmail());
        participantDto.setEventId(participant.getEventId());

        return participantDto;
    }

    /**
     * Converteste o listă de obiecte Participant într-o listă de obiecte ParticipantDto.
     *
     * @param participants Lista de obiecte Participant de conversie.
     * @return Lista de obiecte ParticipantDto rezultate.
     */
    public List<ParticipantDto> convertModelListToDtoList(List<Participant> participants) {
        List<ParticipantDto> participantDtos = new ArrayList<>();

        for(Participant participant: participants) {
            participantDtos.add(convertModelToDto(participant));
        }

        return participantDtos;
    }
}
