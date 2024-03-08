package com.fsa.firststepapp.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clasa care reprezintă obiectul de cerere pentru adăugarea de întrebări.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddQuestionRequest {
    private String text;
    private String user;
    private String category;
}
