package com.enyoi.jpa.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@DiscriminatorValue("STUDENT")
@Getter
@Setter
public class Student extends User {

    @OneToMany(mappedBy = "student")
    private List<StudentCourse> coursesStudents;


}
