package com.fsa.firststepapp.models.mappers;

import com.fsa.firststepapp.models.Announcement;
import com.fsa.firststepapp.models.dto.AnnouncementDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Clasa care se ocupă de conversia dintre Announcement și AnnouncementDto.
 */
@Component
public class AnnouncementMapper {
    public AnnouncementMapper() {
    }

    /**
     * Converteste un obiect Announcement într-un obiect AnnouncementDto.
     *
     * @param announcement Obiectul Announcement de conversie.
     * @return Obiectul AnnouncementDto rezultat.
     */
    public AnnouncementDto convertModelToDto(Announcement announcement) {
        AnnouncementDto announcementDto = new AnnouncementDto();

        announcementDto.setAnnouncementId(announcement.getAnnouncementId());
        announcementDto.setText(announcement.getText());
        announcementDto.setTitle(announcement.getTitle());
        announcementDto.setUrl(announcement.getUrl());
        announcementDto.setUniversity(announcement.getUniversity().getName());
        announcementDto.setFaculty(announcement.getFaculty().getName());

        return announcementDto;
    }

    /**
     * Converteste o listă de obiecte Announcement într-o listă de obiecte AnnouncementDto.
     *
     * @param announcements Lista de obiecte Announcement de conversie.
     * @return Lista de obiecte AnnouncementDto rezultate.
     */
    public List<AnnouncementDto> convertModelListToDtoList(List<Announcement> announcements) {
        List<AnnouncementDto> announcementDtos = new ArrayList<>();

        for(Announcement announcement: announcements) {
            announcementDtos.add(convertModelToDto(announcement));
        }

        return announcementDtos;
    }
}
