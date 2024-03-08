package com.fsa.firststepapp.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Obiectul de transfer de date (DTO) pentru universități.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UniversityDto {
    private Long universityId;
    private String name;
    private String img;
    private List<FacultyDto> faculties;
}
