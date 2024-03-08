package com.fsa.firststepapp.repository;

import com.fsa.firststepapp.models.Announcement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository pentru manipularea datelor entității Announcement.
 */
@Repository
public interface AnnouncementRepository extends CrudRepository<Announcement, Long> {

    /**
     * Găsește un anunț după identificatorul său.
     *
     * @param announcementId Identificatorul anunțului.
     * @return Un obiect Optional care poate conține sau nu anunțul căutat.
     */
    Optional<Announcement> findByAnnouncementId(Long announcementId);
}
