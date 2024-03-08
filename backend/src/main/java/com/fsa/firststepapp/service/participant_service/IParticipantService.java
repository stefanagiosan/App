package com.fsa.firststepapp.service.participant_service;

import com.fsa.firststepapp.models.dto.ParticipantDto;
import com.fsa.firststepapp.models.request.AddParticipantRequest;

import java.util.List;

/**
 * Interfață ce definește operațiile disponibile pentru gestionarea participantilor la evenimente în cadrul aplicației.
 */
public interface IParticipantService {

     /**
      * Adaugă un nou participant.
      *
      * @param addParticipantRequest Obiectul AddParticipantRequest care conține informațiile despre noul participant.
      * @return Obiectul ParticipantDto reprezentând participantul adăugat.
      */
     ParticipantDto addParticipant(AddParticipantRequest addParticipantRequest);

     /**
      * Obține toți participanții disponibili.
      *
      * @return Lista de obiecte ParticipantDto reprezentând participanții.
      */
     List<ParticipantDto> getAllParticipants() ;
}
