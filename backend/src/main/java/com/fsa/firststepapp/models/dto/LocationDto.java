package com.fsa.firststepapp.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Obiectul de transfer de date (DTO) pentru locații.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationDto {
    private Long locationId;
    private String name;
    private String type;
    private String latitude;
    private String longitude;
    private String img;
    private String description;
    private String site;
    private List<EventDto> events;
}
