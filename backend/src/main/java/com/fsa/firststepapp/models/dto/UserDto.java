package com.fsa.firststepapp.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Obiectul de transfer de date (DTO) pentru utilizatori.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private UUID userId;
    private String name;
    private String email;
    private String password;
    private String university;
    private String faculty;
}
