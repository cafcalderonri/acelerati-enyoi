package com.enyoi.jpa.repository;

import com.enyoi.jpa.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

//CourseDAO
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
