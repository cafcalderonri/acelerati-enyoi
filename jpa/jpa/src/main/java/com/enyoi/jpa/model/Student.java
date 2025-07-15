package com.enyoi.jpa.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@DiscriminatorValue("STUDENT")
@Getter
@Setter
public class Student extends User {

    @OneToMany(mappedBy = "student")
    private List<StudentCourse> coursesStudents;

    // SI PUEDE MATRICULAR
    public void matricular(Course course){
        System.out.println("CURSO " + course.getName() + " MATRICULADO ");
    }

}
