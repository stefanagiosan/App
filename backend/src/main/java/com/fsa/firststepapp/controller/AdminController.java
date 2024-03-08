package com.fsa.firststepapp.controller;

import com.fsa.firststepapp.models.dto.*;
import com.fsa.firststepapp.models.request.*;
import com.fsa.firststepapp.models.response.DeleteResponse;
import com.fsa.firststepapp.service.announcement_service.IAnnouncementService;
import com.fsa.firststepapp.service.event_service.IEventService;
import com.fsa.firststepapp.service.faculty_service.IFacultyService;
import com.fsa.firststepapp.service.location_service.ILocationService;
import com.fsa.firststepapp.service.university_service.IUniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlerul pentru operațiunile specifice administratorului.
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/admin")
public class AdminController {
    private final IAnnouncementService announcementService;
    private final IUniversityService universityService;
    private final ILocationService locationService;
    private final IEventService eventService;
    private final IFacultyService facultyService;

    @Autowired
    public AdminController(IAnnouncementService announcementService, IUniversityService universityService,
                           ILocationService locationService, IEventService eventService, IFacultyService facultyService) {
        this.announcementService = announcementService;
        this.universityService = universityService;
        this.locationService = locationService;
        this.eventService = eventService;
        this.facultyService = facultyService;
    }

    /**
     * Endpoint pentru obținerea tuturor anunțurilor
     *
     * @return Lista de obiecte AnnouncementDto.
     */
    @GetMapping("/announcements")
    public List<AnnouncementDto> getAllAnnouncements() {
        return announcementService.getAllAnnouncements();
    }

    /**
     * Endpoint pentru adăugarea unui anunț nou
     *
     * @param announcement Obiectul de tip AddAnswerRequest care conține informațiile necesare pentru adăugarea răspunsului.
     * @return obiectul AnnouncementDto adaugat.
     */
    @PostMapping("/announcements")
    public AnnouncementDto addAnnouncement(@RequestBody AddAnnouncementRequest announcement) {
        return announcementService.addAnnouncement(announcement);
    }

    /**
     * Endpoint pentru actualizarea unui anunț existent
     *
     * @param announcementId ID-ul anunutului pe care dorim sa il actualizam.
     * @param announcement Obiectul de tip AddAnswerRequest care conține informațiile necesare pentru actualizarea răspunsului.
     * @return obiectul AnnouncementDto actualizat.
     */
    @PutMapping("/announcements/{announcementId}")
    public AnnouncementDto updateAnnouncement(@PathVariable String announcementId, @RequestBody AddAnnouncementRequest announcement) {
        return announcementService.updateAnnouncement(announcementId, announcement);
    }

    /**
     * Endpoint pentru stergerea unei anunt
     *
     * @param announcementId ID-ul anunutului pe care dorim sa il stergem.
     */
    @DeleteMapping("/announcements/{announcementId}")
    public DeleteResponse deleteAnnouncement(@PathVariable String announcementId) {
        announcementService.deleteAnnouncement(announcementId);

        return new DeleteResponse("Announcement deleted successfully!!");
    }

    /**
     * Endpoint pentru obținerea tuturor facultatilor
     *
     * @return Lista de obiecte FacultyDto.
     */
    @GetMapping("/faculties")
    public List<FacultyDto> getAllFaculties() {
        return facultyService.getAllFaculties();
    }

    /**
     * Endpoint pentru adăugarea unei facultăți noi
     *
     * @param faculty Obiectul de tip AddFacultyRequest care conține informațiile necesare pentru adaugarea facultatii.
     * @return obiectul FacultyDto adaugat.
     */
    @PostMapping("/faculties")
    public FacultyDto addFaculty(@RequestBody AddFacultyRequest faculty) {
        return facultyService.addFaculty(faculty);
    }

    /**
     * Endpoint pentru actualizarea unei facultăți existente
     *
     * @param facultyId ID-ul facultatii pe care vrem sa o actualizam.
     * @param faculty Obiectul de tip AddFacultyRequest care conține informațiile necesare pentru actualizarea facultatii.
     * @return obiectul FacultyDto actualizat.
     */
    @PutMapping("/faculties/{facultyId}")
    public FacultyDto updateFaculty(@PathVariable String facultyId, @RequestBody AddFacultyRequest faculty) {
        return facultyService.updateFaculty(facultyId, faculty);
    }

    /**
     * Endpoint pentru ștergerea unei facultăți
     *
     * @param facultyId ID-ul facultatii pe care vrem sa o stergem.
     */
    @DeleteMapping("/faculties/{facultyId}")
    public DeleteResponse deleteFaculty(@PathVariable String facultyId) {
        facultyService.deleteFaculty(facultyId);

        return new DeleteResponse("Faculty deleted successfully!!");
    }

    /**
     * Endpoint pentru obținerea tuturor universitatilor
     *
     * @return Lista de obiecte UniversityDto.
     */
    @GetMapping("/universities")
    public List<UniversityDto> getAllUniversities() {
        return universityService.getAllUniversities();
    }

    /**
     * Endpoint pentru adăugarea unei universitati noi
     *
     * @param university Obiectul de tip AddUniversityRequest care conține informațiile necesare pentru adăugarea universitatii.
     * @return obiectul UniversityDto adaugat
     */
    @PostMapping("/universities")
    public UniversityDto addUniversity(@RequestBody AddUniversityRequest university) {
        return universityService.addUniversity(university);
    }

    /**
     * Endpoint pentru actualizarea unei universitati existente
     *
     * @param university Obiectul de tip AddUniversityRequest care conține informațiile necesare pentru actualizarea universitatii.
     * @param universityId ID-ul universitatii pe care vrem sa o actualizam.
     * @return obiectul UniversityDto actualizat
     */
    @PutMapping("/universities/{universityId}")
    public UniversityDto updateUniversity(@PathVariable String universityId, @RequestBody AddUniversityRequest university) {
        return universityService.updateUniversity(universityId, university);
    }

    /**
     * Endpoint pentru ștergerea unei universitati
     *
     * @param universityId ID-ul universitatii pe care vrem sa o stergem.
     */
    @DeleteMapping("/universities/{universityId}")
    public DeleteResponse deleteUniversity(@PathVariable String universityId) {
        universityService.deleteUniversity(universityId);

        return new DeleteResponse("University deleted successfully!!");
    }

    /**
     * Endpoint pentru obținerea tuturor locatiilor
     *
     * @return Lista de obiecte LocationDto.
     */
    @GetMapping("/locations")
    public List<LocationDto> getAllLocations() {
        return locationService.getAllLocations();
    }

    /**
     * Endpoint pentru adăugarea unei locatii noi
     *
     * @param location Obiectul de tip AddLocationRequest care conține informațiile necesare pentru adăugarea locatiei.
     * @return obiectul LocationDto adaugat
     */
    @PostMapping("/locations")
    public LocationDto addLocation(@RequestBody AddLocationRequest location) {
        return locationService.addLocation(location);
    }

    /**
     * Endpoint pentru actualizarea unei locatii existente
     *
     * @param location Obiectul de tip AddLocationRequest care conține informațiile necesare pentru actualizarea locatiei.
     * @param locationId ID-ul lcoatiei pe care vrem sa o actualizam.
     * @return obiectul LocationDto actualizat
     */
    @PutMapping("/locations/{locationId}")
    public LocationDto updateLocation(@PathVariable String locationId, @RequestBody AddLocationRequest location) {
        return locationService.updateLocation(location, locationId);
    }

    /**
     * Endpoint pentru ștergerea unei locatii
     *
     * @param locationId ID-ul lcoatiei pe care vrem sa o stergem.
     */
    @DeleteMapping("/locations/{locationId}")
    public DeleteResponse deleteLocation(@PathVariable String locationId) {
        locationService.deleteLocation(locationId);

        return new DeleteResponse("Location deleted successfully!!");
    }

    /**
     * Endpoint pentru obținerea tuturor evenimentelor
     *
     * @return Lista de obiecte EventDto.
     */
    @GetMapping("/events")
    public List<EventDto> getAllEvents() {
        return eventService.getAllEvents();
    }

    /**
     * Endpoint pentru adăugarea unui eveniment nou
     *
     * @param event Obiectul de tip AddEventRequest care conține informațiile necesare pentru adăugarea evenimentului.
     * @return obiectul EventDto adaugat
     */
    @PostMapping("/events")
    public EventDto addEvent(@RequestBody AddEventRequest event) {
        return eventService.addEvent(event);
    }

    /**
     * Endpoint pentru actualizarea unui eveniment existente
     *
     * @param event Obiectul de tip AddEventRequest care conține informațiile necesare pentru actualizarea evenimentului.
     * @param eventId ID-ul evenimentului pe care vrem sa il actualizam.
     */
    @PutMapping("/events/{eventId}")
    public EventDto updateEvent(@PathVariable String eventId, @RequestBody AddEventRequest event) {
        return eventService.updateEvent(eventId, event);
    }

    /**
     * Endpoint pentru ștergerea unui eveniment
     *
     * @param eventId ID-ul evenimentului pe care vrem sa il stergem.
     */
    @DeleteMapping("/events/{eventId}")
    public DeleteResponse deleteEvent(@PathVariable String eventId) {
        eventService.deleteEvent(eventId);

        return new DeleteResponse("Event deleted successfully!!");
    }
}
