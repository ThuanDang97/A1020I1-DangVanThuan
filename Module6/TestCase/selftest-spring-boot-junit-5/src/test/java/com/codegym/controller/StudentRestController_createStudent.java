package com.codegym.controller;

import com.codegym.dto.ClassStudentDto;
import com.codegym.dto.StudentDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentRestController_createStudent {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createStudent_18() throws Exception {
        StudentDto studentDto = new StudentDto();
        studentDto.setName("Nguyen Van B");
        studentDto.setGrade(9.0);
        studentDto.setDateOfBirth("2000-10-06");
        studentDto.setGender(1);
        ClassStudentDto classStudentDto = new ClassStudentDto();
        classStudentDto.setId(2);
        studentDto.setClassStudentDto(classStudentDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/studentRest/create")
                        .content(this.objectMapper.writeValueAsString(studentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                        .andDo(print())
                        .andExpect(status().is2xxSuccessful());

    }

}
