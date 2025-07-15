package com.enyoi.jpa.service;

import com.enyoi.jpa.dto.CreateCourseRequestDto;
import com.enyoi.jpa.dto.GetCoursesResponseDto;
import com.enyoi.jpa.mapper.CourseMapper;
import com.enyoi.jpa.mapper.CourseMapperInterface;
import com.enyoi.jpa.model.Course;
import com.enyoi.jpa.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class CourseService { //ORQUESTAR OPERACIONES RELACIONADAS A LOS CURSOS

    private final CourseRepository courseRepository; //ABSTRACCIÓN
    private final CourseMapperInterface courseMapper; //ABSTRACCIÓN

    @Transactional
    public List<GetCoursesResponseDto> getCourses(){
        List<Course> courses = courseRepository.findAll();
        return courseMapper.mapCourseListToGetCourseResponseDtoList(courses);
    }

    @Transactional
    public void saveNewCourse(CreateCourseRequestDto dto){
        Course course = courseMapper.mapCreateCourseRequestDtoToCourse(dto);

        courseRepository.save(course);

        throw new RuntimeException("ERROR PREMEDITADO");
    }





}
