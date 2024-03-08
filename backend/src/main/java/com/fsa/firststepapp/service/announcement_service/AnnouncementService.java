package com.fsa.firststepapp.service.announcement_service;

import com.fsa.firststepapp.models.Announcement;
import com.fsa.firststepapp.models.Faculty;
import com.fsa.firststepapp.models.University;
import com.fsa.firststepapp.models.dto.AnnouncementDto;
import com.fsa.firststepapp.models.exception.models.EntityNotFoundException;
import com.fsa.firststepapp.models.mappers.AnnouncementMapper;
import com.fsa.firststepapp.models.request.AddAnnouncementRequest;
import com.fsa.firststepapp.repository.AnnouncementRepository;
import com.fsa.firststepapp.repository.FacultyRepository;
import com.fsa.firststepapp.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementService implements IAnnouncementService {
    private final AnnouncementRepository announcementRepository;
    private final FacultyRepository facultyRepository;
    private final UniversityRepository universityRepository;
    private final AnnouncementMapper announcementMapper;

    @Autowired
    public AnnouncementService(AnnouncementRepository announcementRepository, FacultyRepository facultyRepository, UniversityRepository universityRepository, AnnouncementMapper announcementMapper) {
        this.announcementRepository = announcementRepository;
        this.facultyRepository = facultyRepository;
        this.universityRepository = universityRepository;
        this.announcementMapper = announcementMapper;
    }

    @Override
    public List<AnnouncementDto> getAllAnnouncements() {
        List<Announcement> announcements = (List<Announcement>) announcementRepository.findAll();

        if(announcements.isEmpty()) {
            throw new EntityNotFoundException("Announcements Not Found!!");
        }

        return announcementMapper.convertModelListToDtoList(announcements);
    }

    @Override
    public AnnouncementDto addAnnouncement(AddAnnouncementRequest announcement) {
        Announcement announcementToAdd = new Announcement();
        Faculty faculty = facultyRepository.findFacultyByName(announcement.getFaculty()).orElseThrow();
        University university = universityRepository.findUniversityByName(announcement.getUniversity()).orElseThrow();

        announcementToAdd.setTitle(announcement.getTitle());
        announcementToAdd.setText(announcement.getText());
        announcementToAdd.setFaculty(faculty);
        announcementToAdd.setUniversity(university);
        announcementToAdd.setUrl(announcement.getUrl());

        return announcementMapper.convertModelToDto(announcementRepository.save(announcementToAdd));
    }

    @Override
    public AnnouncementDto updateAnnouncement(String announcementId, AddAnnouncementRequest announcement) {
        Announcement announcementToUpdate = announcementRepository.findByAnnouncementId(Long.parseLong(announcementId)).orElseThrow();
        Faculty faculty = facultyRepository.findFacultyByName(announcement.getFaculty()).orElseThrow();
        University university = universityRepository.findUniversityByName(announcement.getUniversity()).orElseThrow();

        announcementToUpdate.setTitle(announcement.getTitle());
        announcementToUpdate.setText(announcement.getText());
        announcementToUpdate.setFaculty(faculty);
        announcementToUpdate.setUniversity(university);
        announcementToUpdate.setUrl(announcement.getUrl());

        return announcementMapper.convertModelToDto(announcementRepository.save(announcementToUpdate));
    }

    @Override
    public void deleteAnnouncement(String announcementId) {
        Announcement announcement = announcementRepository.findByAnnouncementId(Long.parseLong(announcementId)).orElseThrow();

        announcementRepository.delete(announcement);
    }
}
