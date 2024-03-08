package com.fsa.firststepapp.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clasa care reprezintă obiectul de răspuns pentru ștergere.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeleteResponse {
    private String message;
}
