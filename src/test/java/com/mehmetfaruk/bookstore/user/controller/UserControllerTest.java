package com.mehmetfaruk.bookstore.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mehmetfaruk.bookstore.builder.UserBuilder;
import com.mehmetfaruk.bookstore.user.model.UserDAO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@Order(1)
class UserControllerTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    void signUp() throws Exception {
        UserDAO userDAO = new UserBuilder()
                .buildMockObject()
                .build();
        String jsonUser = objectMapper.writeValueAsString(userDAO);

        ResultActions resultActions = this.mockMvc
                .perform(
                        post("/api/v1/users/signUp")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonUser))
                .andDo(print())
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        UserDAO resultUser = objectMapper.readValue(contentAsString, UserDAO.class);

        Assertions.assertNotNull(resultUser.getId());
    }

    @Test
    void login() {
    }
}