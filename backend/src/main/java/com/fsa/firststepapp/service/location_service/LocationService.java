package com.fsa.firststepapp.service.location_service;

import com.fsa.firststepapp.models.Location;
import com.fsa.firststepapp.models.dto.LocationDto;
import com.fsa.firststepapp.models.exception.models.EntityNotFoundException;
import com.fsa.firststepapp.models.mappers.LocationMapper;
import com.fsa.firststepapp.models.request.AddLocationRequest;
import com.fsa.firststepapp.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService implements ILocationService {
    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    @Autowired
    public LocationService(LocationRepository locationRepository, LocationMapper locationMapper) {
        this.locationRepository = locationRepository;
        this.locationMapper = locationMapper;
    }

    @Override
    public List<LocationDto> getAllLocations() {
        List<Location> locations = (List<Location>) locationRepository.findAll();

        if (locations.isEmpty()) {
            throw new EntityNotFoundException("Locations Not Found!!");
        }

        return locationMapper.convertModelListToDtoList(locations);
    }

    @Override
    public LocationDto addLocation(AddLocationRequest location) {
        Location locationToAdd = new Location();

        locationToAdd.setName(location.getName());
        locationToAdd.setType(location.getType());
        locationToAdd.setLatitude(location.getLatitude());
        locationToAdd.setLongitude(location.getLongitude());
        locationToAdd.setImg(location.getImg());
        locationToAdd.setSite(location.getSite());
        locationToAdd.setDescription(location.getDescription());
        locationToAdd.setEvents(new ArrayList<>());

        return locationMapper.convertModelToDto(locationRepository.save(locationToAdd));
    }

    @Override
    public LocationDto updateLocation(AddLocationRequest location, String locationId) {
        Location locationToUpdate = locationRepository.findByLocationId(Long.parseLong(locationId)).orElseThrow();

        locationToUpdate.setName(location.getName());
        locationToUpdate.setType(location.getType());
        locationToUpdate.setLatitude(location.getLatitude());
        locationToUpdate.setLongitude(location.getLongitude());
        locationToUpdate.setImg(location.getImg());
        locationToUpdate.setSite(location.getSite());
        locationToUpdate.setDescription(location.getDescription());

        return locationMapper.convertModelToDto(locationRepository.save(locationToUpdate));
    }

    @Override
    public void deleteLocation(String locationId) {
        Location location = locationRepository.findByLocationId(Long.parseLong(locationId)).orElseThrow();

        locationRepository.delete(location);
    }
}
