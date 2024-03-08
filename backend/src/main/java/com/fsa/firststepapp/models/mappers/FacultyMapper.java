package com.fsa.firststepapp.models.mappers;

import com.fsa.firststepapp.models.Faculty;
import com.fsa.firststepapp.models.dto.FacultyDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Clasa care se ocupă de conversia dintre Faculty și FacultyDto.
 */
@Component
public class FacultyMapper {

    public FacultyMapper() {
    }

    /**
     * Converteste un obiect Faculty într-un obiect FacultyDto.
     *
     * @param faculty Obiectul Faculty de conversie.
     * @return Obiectul FacultyDto rezultat.
     */
    public FacultyDto convertModelToDto(Faculty faculty) {
        FacultyDto facultyDto = new FacultyDto();
        
        facultyDto.setFacultyId(faculty.getFacultyId());
        facultyDto.setFacultyName(faculty.getName());
        facultyDto.setUniversityName(faculty.getUniversity().getName());

        return facultyDto;
    }

    /**
     * Converteste o listă de obiecte Faculty într-o listă de obiecte FacultyDto.
     *
     * @param faculties Lista de obiecte Faculty de conversie.
     * @return Lista de obiecte FacultyDto rezultate.
     */
    public List<FacultyDto> convertModelListToDtoList(List<Faculty> faculties) {
        List<FacultyDto> facultyDtos = new ArrayList<>();

        for(Faculty faculty: faculties) {
            facultyDtos.add(convertModelToDto(faculty));
        }

        return facultyDtos;
    }
}
