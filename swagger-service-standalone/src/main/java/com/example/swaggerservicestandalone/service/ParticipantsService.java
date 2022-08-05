package com.example.swaggerservicestandalone.service;

import com.example.swaggerservicestandalone.controller.ResourceNotFoundException;
import com.example.swaggerservicestandalone.entity.Participants;
import com.example.swaggerservicestandalone.repository.ParticipantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParticipantsService {

    @Autowired
    private ParticipantsRepository participantsRepository;

    public List<Participants> findAll() {

        return participantsRepository.findAll();

    }

    public Participants save(Participants participants) {
        return participantsRepository.save(participants);

    }

    public void deleteById(long id) throws ResourceNotFoundException {
        {

            Optional<Participants> participants_delete = participantsRepository.findById(id);

            if (!participants_delete.isPresent()) {
                throw new ResourceNotFoundException("Resource Not Found!!!!");
            } else
                participantsRepository.delete(participants_delete.get());

        }


    }


    public Participants updateParticipants(Participants participants) throws ResourceNotFoundException {

        Optional<Participants> participants_update = participantsRepository.findById(participants.getId());

        if (!participants_update.isPresent()) {
            throw new ResourceNotFoundException("Resource Not Found!!!!");
        } else {

            Participants participants1 = participants_update.get();
            participants1.setId(participants.getId());
            participants1.setName(participants.getName());
            participants1.setCatagory(participants.getCatagory());
            participants1.setClas(participants.getClas());

            return participantsRepository.save(participants1);
        }
    }


    public Participants findParticipant(Long id) throws ResourceNotFoundException {

        Optional<Participants> participants_findId = participantsRepository.findById(id);
        if (!participants_findId.isPresent()) {
            throw new ResourceNotFoundException("Resource Not Found!!!!");
        } else {
              return participants_findId.get();

        }

        }


    }