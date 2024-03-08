package com.fsa.firststepapp.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clasa care reprezintă obiectul de cerere pentru adăugarea de anunțuri.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddAnnouncementRequest {
    private String title;
    private String text;
    private String url;
    private String university;
    private String faculty;
}
