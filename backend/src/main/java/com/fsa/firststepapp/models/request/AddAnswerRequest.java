package com.fsa.firststepapp.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clasa care reprezintă obiectul de cerere pentru adăugarea de răspunsuri.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddAnswerRequest {
    private String text;
    private String user;
    private Long question;
}
