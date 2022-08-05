package com.example.swaggerservicestandalone.controller;

import com.example.swaggerservicestandalone.entity.Participants;
import com.example.swaggerservicestandalone.repository.ParticipantsRepository;
import com.example.swaggerservicestandalone.service.ParticipantsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/participants")
public class ParticipantsController {

    @Autowired
    private ParticipantsService participantsService;

    @Operation(summary = "This is to fetch All the Participants stored in Db")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Details of All the Participants",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Page not found",
                    content = @Content)
    })
    @GetMapping("/")
    public ResponseEntity<List<Participants>> allParticipants() {

        try {
            return new ResponseEntity<List<Participants>>(participantsService.findAll(), HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @Operation(summary = "This is to add  the Participants in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = " Participant details saved in database",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = " Page Not Found",
                    content = @Content)
    })

    @PostMapping("/")
    public ResponseEntity<Participants> create(@RequestBody Participants participants){

        try {
            return new ResponseEntity<Participants>(participantsService.save(participants), HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }


    @Operation(summary = "This is to delete  the Participants in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = " Participant deleted from the database",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = " Page Not Found",
                    content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) throws ResourceNotFoundException{
        //participantsService.findById(id);
        participantsService.deleteById(id);
        return new ResponseEntity<String>("Deleted",HttpStatus.OK);
    }


    @Operation(summary = "This is to udate  the Participants in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = " Participant details updated in database",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = " Page Not Found",
                    content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<Participants> updateParticipants(@RequestBody Participants participants, @PathVariable Long id) throws ResourceNotFoundException{

        participants.setId(id);
        return new ResponseEntity<Participants>(participantsService.updateParticipants(participants) ,HttpStatus.CREATED);


    }

    @Operation(summary = "This is to get  the details of particular  Participants in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = " Participant details fetched from database",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = " Page Not Found",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Participants> findParticipant(@PathVariable Long id) throws ResourceNotFoundException{

        return new ResponseEntity<Participants>(participantsService.findParticipant(id),HttpStatus.CREATED);


    }

}
