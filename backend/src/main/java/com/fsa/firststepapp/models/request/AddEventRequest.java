package com.fsa.firststepapp.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Clasa care reprezintă obiectul de cerere pentru adăugarea de evenimente.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddEventRequest {
    private Long eventId;
    private String name;
    private String description;
    private Long participants;
    private String locationName;
    private Date eventDate;
}
