package com.fsa.firststepapp.controller;

import com.fsa.firststepapp.models.dto.UniversityDto;
import com.fsa.firststepapp.service.university_service.IUniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlerul pentru gestionarea universităților.
 */
@RestController
@CrossOrigin(origins="http://localhost:8100", allowedHeaders = "*")
@RequestMapping("/api/universities")
public class UniversityController {
    private final IUniversityService universityService;

    @Autowired
    public UniversityController(IUniversityService universityService) {
        this.universityService = universityService;
    }

    /**
     * Endpoint pentru obținerea tuturor universităților.
     *
     * @return Lista de obiecte UniversityDto.
     */
    @GetMapping("")
    public List<UniversityDto> getAllUniversities() {
        return universityService.getAllUniversities();
    }
}
