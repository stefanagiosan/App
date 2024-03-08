package com.fsa.firststepapp.models.mappers;

import com.fsa.firststepapp.models.University;
import com.fsa.firststepapp.models.dto.UniversityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Clasa care se ocupă de conversia dintre University și UniversityDto.
 */
@Component
public class UniversityMapper {
    private final FacultyMapper facultyMapper;

    @Autowired
    public UniversityMapper(FacultyMapper facultyMapper) {
        this.facultyMapper = facultyMapper;
    }

    /**
     * Converteste un obiect University într-un obiect UniversityDto.
     * @param university Obiectul University de conversie.
     * @return Obiectul UniversityDto rezultat.
     */
    public UniversityDto convertModelToDto(University university) {
        UniversityDto universityDto = new UniversityDto();

        universityDto.setUniversityId(university.getUniversityId());
        universityDto.setName(university.getName());
        universityDto.setImg(university.getImg());
        universityDto.setFaculties(facultyMapper.convertModelListToDtoList(university.getFaculties()));

        return universityDto;
    }

    /**
     * Converteste o listă de obiecte University într-o listă de obiecte UniversityDto.
     * @param universities Lista de obiecte University de conversie.
     * @return Lista de obiecte UniversityDto rezultate.
     */
    public List<UniversityDto> convertModelListToDtoList(List<University> universities) {
        List<UniversityDto> universityDtos = new ArrayList<>();

        for(University university: universities) {
            universityDtos.add(convertModelToDto(university));
        }

        return universityDtos;
    }
}
