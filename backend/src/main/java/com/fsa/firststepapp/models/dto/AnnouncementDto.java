package com.fsa.firststepapp.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Obiectul de transfer de date (DTO) pentru anunțuri.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementDto {
    private Long announcementId;
    private String title;
    private String text;
    private String url;
    private String university;
    private String faculty;
}
