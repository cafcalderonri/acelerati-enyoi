package com.enyoi.jpa.mapper;

import com.enyoi.jpa.dto.CreateCourseRequestDto;
import com.enyoi.jpa.dto.GetCoursesResponseDto;
import com.enyoi.jpa.dto.TaskDto;
import com.enyoi.jpa.model.Course;
import com.enyoi.jpa.model.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CourseMapper implements CourseMapperInterface {

    private final GenericMapper<TaskDto, Task> taskMapper;

    @Override
    public List<GetCoursesResponseDto> mapCourseListToGetCourseResponseDtoList(List<Course> courses){
        List<GetCoursesResponseDto> responseDtos = new ArrayList<>();
        for(Course course: courses){
            GetCoursesResponseDto dto = mapCourseToGetCourseResponseDto(course);
            responseDtos.add(dto);
        }
        return responseDtos;
    }

    @Override
    public GetCoursesResponseDto mapCourseToGetCourseResponseDto(Course course){
        GetCoursesResponseDto dto = new GetCoursesResponseDto();
        dto.setId(course.getId());
        dto.setName(course.getName());
        dto.setDescription(course.getDescription());
        dto.setTaskDtos(
                taskMapper.modelListToDtoList(course.getTasks()));
        return dto;
    }

    @Override
    public Course mapCreateCourseRequestDtoToCourse(CreateCourseRequestDto dto){
        Course course = new Course();
        course.setName(dto.getName());
        course.setDescription(dto.getDescription());
        course.setTeacher(null);
        course.setTasks(new ArrayList<>());
        course.setCoursesStudents(new ArrayList<>());
        return course;
    }



}
