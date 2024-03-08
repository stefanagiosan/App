package com.fsa.firststepapp.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Obiectul de transfer de date (DTO) pentru evenimente.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {
    private Long eventId;
    private String name;
    private String description;
    private Long participants;
    private String locationName;
    private Date eventDate;
}
