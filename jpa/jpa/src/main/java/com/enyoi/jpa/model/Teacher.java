package com.enyoi.jpa.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@DiscriminatorValue("TEACHER")
@Getter
@Setter
public class Teacher extends User {

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
    private List<Course> courses;
}
