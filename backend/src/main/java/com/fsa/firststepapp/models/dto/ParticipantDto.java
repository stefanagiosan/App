package com.fsa.firststepapp.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Obiectul de transfer de date (DTO) pentru participanți.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantDto {
    private Long participantId;
    private String userEmail;
    private Long eventId;
}
