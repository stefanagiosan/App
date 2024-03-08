package com.fsa.firststepapp.controller;

import com.fsa.firststepapp.models.dto.LocationDto;
import com.fsa.firststepapp.service.location_service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlerul pentru gestionarea locațiilor.
 */
@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
@RequestMapping("/api/locations")
public class LocationController {
    private final ILocationService locationService;

    @Autowired
    public LocationController(ILocationService locationService) {
        this.locationService = locationService;
    }

    /**
     * Endpoint pentru obținerea tuturor locațiilor.
     *
     * @return Lista de obiecte LocationDto.
     */
    @GetMapping("")
    public List<LocationDto> getAllLocations() {
        return locationService.getAllLocations();
    }
}
