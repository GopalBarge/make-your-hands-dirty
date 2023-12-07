package com.make.your.hands.dirty.common.integration;

import com.make.your.hands.dirty.common.controller.UserController;
import com.make.your.hands.dirty.common.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void getAllUsers() throws Exception {
        // Mock the service call
        when(userService.getAllUsers()).thenReturn(Collections.emptyList());

        // Perform the MVC request
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));

        // Verify that the service method was called
        verify(userService, times(1)).getAllUsers();
    }

    // Add more tests for other endpoints
}
