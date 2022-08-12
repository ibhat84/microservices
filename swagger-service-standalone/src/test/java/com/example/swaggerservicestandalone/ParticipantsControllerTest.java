package com.example.swaggerservicestandalone;

import com.example.swaggerservicestandalone.controller.ParticipantsController;
import com.example.swaggerservicestandalone.entity.Participants;
import com.example.swaggerservicestandalone.service.ParticipantsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.ws.rs.core.MediaType;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ParticipantsController.class)
public class ParticipantsControllerTest {

    @MockBean
    ParticipantsService participantsService;

    @Autowired
    MockMvc mockMvc;



    @Test
    public void testallParticipants() throws Exception{

        Participants participants = new Participants(1,"Indu","6th Grade", "Violin");
        List<Participants> participantsList = Arrays.asList(participants);

        Mockito.when(participantsService.findAll()).thenReturn(participantsList);

        mockMvc.perform(get("/participants/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(1)))
                .andExpect(jsonPath("$[0].name", Matchers.is("Indu")));

    }

    @Test
    public void testcreateParticipants() throws Exception{

        Participants participants = new Participants(1,"Indu","6th Grade", "Violin");

        Mockito.when(participantsService.save(Mockito.any(Participants.class))).thenReturn(participants);

        ObjectMapper mapper = new ObjectMapper();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/participants/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(participants).getBytes(StandardCharsets.UTF_8))
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.status().isCreated())
                        .andReturn();

        Assertions.assertThat(result).isNotNull();
        String participantsJsonResponse = result.getResponse().getContentAsString();
        Assertions.assertThat(participantsJsonResponse).isNotEmpty();
        Assertions.assertThat(participantsJsonResponse).isEqualToIgnoringCase(mapper.writeValueAsString(participants));

    }






}
