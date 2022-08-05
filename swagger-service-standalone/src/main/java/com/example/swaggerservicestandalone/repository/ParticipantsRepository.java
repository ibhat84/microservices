package com.example.swaggerservicestandalone.repository;

import com.example.swaggerservicestandalone.entity.Participants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  ParticipantsRepository extends JpaRepository<Participants, Long> {

}
