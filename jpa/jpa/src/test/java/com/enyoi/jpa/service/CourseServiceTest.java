package com.enyoi.jpa.service;

import com.enyoi.jpa.dto.CreateCourseRequestDto;
import com.enyoi.jpa.dto.GetCoursesResponseDto;
import com.enyoi.jpa.model.Course;
import com.enyoi.jpa.model.Teacher;
import com.enyoi.jpa.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CourseServiceTest {

    @Mock
    CourseRepository courseRepository; //¿Cómo resuelvo esta dependencia?

    @InjectMocks
    CourseService courseService;


    @Test
    void testGetCourses(){
        //ARRANGE
        List<Course> cursosMock = getAListOfCourses();
        when(courseRepository.findAll()).thenReturn(cursosMock);

        //ACT
        List<GetCoursesResponseDto> actualResponse = courseService.getCourses();
        GetCoursesResponseDto actualResponseDto = actualResponse.get(0);

        //ASSERT
        assertEquals("Course Dummy", actualResponseDto.getName());
        assertEquals("This is a test", actualResponseDto.getDescription());
        assertNull(actualResponseDto.getId());

    }


    @Test
    void testExceptionWhenSaveCourse(){
        //ARRANGE
        CreateCourseRequestDto input = getAnInstanceDummy();
        //ACT --- ASSERT
        assertThrows(RuntimeException.class, () -> courseService.saveNewCourse(input));

    }

    private CreateCourseRequestDto getAnInstanceDummy(){
        CreateCourseRequestDto dto = new CreateCourseRequestDto();
        dto.setName("Hola");
        dto.setDescription("Mundo!");
        return dto;
    }

    private List<Course> getAListOfCourses(){
        Course course = new Course();
        course.setName("Course Dummy");
        course.setDescription("This is a test");
        course.setTeacher(new Teacher());
        course.setTasks(new ArrayList<>());
        return List.of(course);
    }

}
