package com.fsa.firststepapp.models.mappers;

import com.fsa.firststepapp.models.Location;
import com.fsa.firststepapp.models.dto.LocationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Clasa care se ocupă de conversia dintre Location și LocationDto.
 */
@Component
public class LocationMapper {
    private final EventMapper eventMapper;

    @Autowired
    public LocationMapper(EventMapper eventMapper) {
        this.eventMapper = eventMapper;
    }

    /**
     * Converteste un obiect Location într-un obiect LocationDto.
     *
     * @param location Obiectul Location de conversie.
     * @return Obiectul LocationDto rezultat.
     */
    public LocationDto convertModelToDto(Location location) {
        LocationDto locationDto = new LocationDto();

        locationDto.setLocationId(location.getLocationId());
        locationDto.setName(location.getName());
        locationDto.setType(location.getType());
        locationDto.setLatitude(location.getLatitude());
        locationDto.setLongitude(location.getLongitude());
        locationDto.setImg(location.getImg());
        locationDto.setDescription(location.getDescription());
        locationDto.setSite(location.getSite());
        locationDto.setEvents(eventMapper.convertModelListToDtoList(location.getEvents()));

        return locationDto;
    }

    /**
     * Converteste o listă de obiecte Location într-o listă de obiecte LocationDto.
     *
     * @param locations Lista de obiecte Location de conversie.
     * @return Lista de obiecte LocationDto rezultate.
     */
    public List<LocationDto> convertModelListToDtoList(List<Location> locations) {
        List<LocationDto> locationDtos = new ArrayList<>();

        for(Location location: locations) {
            locationDtos.add(convertModelToDto(location));
        }

        return locationDtos;
    }
}
