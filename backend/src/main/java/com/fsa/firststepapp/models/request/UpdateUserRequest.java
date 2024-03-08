package com.fsa.firststepapp.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clasa care reprezintă obiectul de cerere pentru actualizarea informațiilor despre utilizator.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserRequest {
    private String name;
    private String password;
    private String newEmail;
    private String oldEmail;
}
