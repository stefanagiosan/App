package com.fsa.firststepapp.models.mappers;

import com.fsa.firststepapp.models.Event;
import com.fsa.firststepapp.models.dto.EventDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Clasa care se ocupă de conversia dintre Event și EventDto.
 */
@Component
public class EventMapper {
    public EventMapper() {
    }

    /**
     * Converteste un obiect Event într-un obiect EventDto.
     *
     * @param event Obiectul Event de conversie.
     * @return Obiectul EventDto rezultat.
     */
    public EventDto convertModelToDto(Event event) {
        EventDto eventDto = new EventDto();

        eventDto.setEventId(event.getEventId());
        eventDto.setName(event.getName());
        eventDto.setDescription(event.getDescription());
        eventDto.setParticipants(event.getParticipants());
        eventDto.setLocationName(event.getLocation().getName());
        eventDto.setEventDate(event.getEventDate());

        return eventDto;
    }

    /**
     * Converteste o listă de obiecte Event într-o listă de obiecte EventDto.
     *
     * @param events Lista de obiecte Event de conversie.
     * @return Lista de obiecte EventDto rezultate.
     */
    public List<EventDto> convertModelListToDtoList(List<Event> events) {
        List<EventDto> eventDtos = new ArrayList<>();

        for(Event event: events) {
            eventDtos.add(convertModelToDto(event));
        }

        return eventDtos;
    }
}
