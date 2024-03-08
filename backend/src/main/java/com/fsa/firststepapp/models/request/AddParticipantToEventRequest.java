package com.fsa.firststepapp.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clasa care reprezintă obiectul de cerere pentru adăugarea de participanți la un eveniment.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddParticipantToEventRequest {
    private Long eventId;
    private Long participants;
}
