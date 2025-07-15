package com.enyoi.jpa.service;

import com.enyoi.jpa.model.Course;
import com.enyoi.jpa.model.Student;

public class StudentService {

    //UN STUDENT DE INTERCAMBIO
    public void matricularCursoEstudiante(Course course, Student student){
        student.matricular(course); //---> VA A FALLAR --> ROMPE SUSTITUCIÓN DE LISKOV
    }

}
