package com.fsa.firststepapp.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Obiectul de transfer de date (DTO) pentru facultăți.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacultyDto {
    private Long facultyId;
    private String facultyName;
    private String universityName;
}
