package com.enyoi.jpa.service;

import com.enyoi.jpa.model.Course;
import com.enyoi.jpa.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.ArrayList;
import java.util.List;


@AutoConfigureMockMvc //ANOTACIÓN PARA LA CONFIGURACIÓN POR DEFECTO
@SpringBootTest //LEVANTEME UN CONTEXTO A MODO DE PRUEBA   ---- PORQUE VOY A HACER UNA PRUEBA DE INTEGRACIÓN
class CourseServiceIntegrationTest {

    @Autowired
    MockMvc mockMvc; //CREA UN OBJETO QUE ME SIRVE COMO SERVLET DE PRUEBAS

    @MockitoBean
    CourseRepository courseRepository;

    @Test
    void obtenerUsuarios() throws Exception {
        when(courseRepository.findAll()).thenReturn(getCourseList());

        mockMvc.perform(get("/api/v1/course"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(1));

    }

    @Test
    void test_saveCourse_throwRuntimeException() throws Exception {
        mockMvc.perform(post("/api/v1/course")
                .content("{\n" +
                        "    \"name\": \"Geografia\",\n" +
                        "    \"description\": \"cualquier cosa\"\n" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }



    private List<Course> getCourseList(){
        Course course = new Course();
        course.setTasks(new ArrayList<>());
        return List.of(course); //UN SOLO CURSO
    }



}
