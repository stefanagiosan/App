package com.fsa.firststepapp.service.faculty_service;

import com.fsa.firststepapp.models.Faculty;
import com.fsa.firststepapp.models.University;
import com.fsa.firststepapp.models.dto.FacultyDto;
import com.fsa.firststepapp.models.exception.models.EntityNotFoundException;
import com.fsa.firststepapp.models.mappers.FacultyMapper;
import com.fsa.firststepapp.models.request.AddFacultyRequest;
import com.fsa.firststepapp.repository.FacultyRepository;
import com.fsa.firststepapp.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacultyService implements IFacultyService {
    private final FacultyRepository facultyRepository;
    private final UniversityRepository universityRepository;
    private final FacultyMapper facultyMapper;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository, UniversityRepository universityRepository, FacultyMapper facultyMapper) {
        this.facultyRepository = facultyRepository;
        this.universityRepository = universityRepository;
        this.facultyMapper = facultyMapper;
    }

    @Override
    public List<FacultyDto> getAllFaculties() {
        List<Faculty> faculties = (List<Faculty>) facultyRepository.findAll();

        if(faculties.isEmpty()) {
            throw new EntityNotFoundException("Faculties not found!!");
        }

        return facultyMapper.convertModelListToDtoList(faculties);
    }

    @Override
    public FacultyDto addFaculty(AddFacultyRequest faculty) {
        University university = universityRepository.findUniversityByName(faculty.getUniversityName()).orElseThrow();
        Faculty facultyToAdd = new Faculty();

        facultyToAdd.setName(faculty.getFacultyName());
        facultyToAdd.setUniversity(university);
        facultyToAdd.setUsers(new ArrayList<>());
        facultyToAdd.setAnnouncements(new ArrayList<>());

        return facultyMapper.convertModelToDto(facultyRepository.save(facultyToAdd));
    }

    @Override
    public FacultyDto updateFaculty(String facultyId, AddFacultyRequest faculty) {
        Faculty facultyToUpdate = facultyRepository.findByFacultyId(Long.parseLong(facultyId)).orElseThrow();
        University university = universityRepository.findUniversityByName(faculty.getUniversityName()).orElseThrow();

        facultyToUpdate.setName(faculty.getFacultyName());
        facultyToUpdate.setUniversity(university);

        return facultyMapper.convertModelToDto(facultyRepository.save(facultyToUpdate));
    }

    @Override
    public void deleteFaculty(String facultyId) {
        Faculty faculty = facultyRepository.findByFacultyId(Long.parseLong(facultyId)).orElseThrow();

        facultyRepository.delete(faculty);
    }
}
