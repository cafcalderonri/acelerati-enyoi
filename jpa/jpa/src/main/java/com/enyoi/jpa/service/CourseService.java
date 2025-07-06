package com.enyoi.jpa.service;

import com.enyoi.jpa.dto.GetCoursesResponseDto;
import com.enyoi.jpa.dto.TaskDto;
import com.enyoi.jpa.model.Course;
import com.enyoi.jpa.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;


    public List<GetCoursesResponseDto> getCourses(){
        List<Course> courses = courseRepository.findAll();
        return mapCourses(courses);
    }

    private List<GetCoursesResponseDto> mapCourses(List<Course> courses){
        List<GetCoursesResponseDto> responseDtos = new ArrayList<>();
        for(Course course: courses){
            GetCoursesResponseDto dto = new GetCoursesResponseDto();
            dto.setId(course.getId());
            dto.setName(course.getName());
            dto.setDescription(course.getDescription());
            dto.setName(course.getName());
            TaskDto taskDto = new TaskDto();
            taskDto.setTitle("Task de prueba");
            dto.setTask(taskDto);
            responseDtos.add(dto);
        }
        return responseDtos;
    }


}
