package com.fsa.firststepapp.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clasa care reprezintă obiectul de cerere pentru adăugarea de locații.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddLocationRequest {
    private String name;
    private String type;
    private String latitude;
    private String longitude;
    private String img;
    private String description;
    private String site;
}
