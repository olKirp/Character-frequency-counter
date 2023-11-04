package com.t1consulting.counter.controller;

import com.t1consulting.counter.service.FrequencyCounterService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FrequencyCounterController.class)
class FrequencyCounterControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    FrequencyCounterService service;

    @Test
    void givenNormalString_thanReturnsOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/frequencyCounter/count")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("abc"))
                .andExpect(status().isOk());
    }

    @Test
    void givenEmptyString_thanReturnsBadRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/frequencyCounter/count")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andExpect(status().isBadRequest());
    }

    @Test
    void givenExceptionThrowingByService_thanReturnsBadRequest() throws Exception {
        Mockito.when(service.countCharacterFrequency("a")).thenThrow(new IllegalArgumentException());

        mockMvc.perform(MockMvcRequestBuilders.post("/frequencyCounter/count")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("a"))
                .andExpect(status().isInternalServerError());
    }
}