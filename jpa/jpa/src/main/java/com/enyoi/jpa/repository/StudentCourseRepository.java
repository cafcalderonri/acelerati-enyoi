package com.enyoi.jpa.repository;

import com.enyoi.jpa.model.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;

//DAO
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Integer> {
}
