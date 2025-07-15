package com.enyoi.jpa.mapper;

import com.enyoi.jpa.dto.CreateCourseRequestDto;
import com.enyoi.jpa.dto.GetCoursesResponseDto;
import com.enyoi.jpa.model.Course;

import java.util.List;

public interface CourseMapperInterface {

    List<GetCoursesResponseDto> mapCourseListToGetCourseResponseDtoList(List<Course> courses);
    GetCoursesResponseDto mapCourseToGetCourseResponseDto(Course course);
    Course mapCreateCourseRequestDtoToCourse(CreateCourseRequestDto dto);

}
