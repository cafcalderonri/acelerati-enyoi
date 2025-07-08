package com.enyoi.jpa.service;

import com.enyoi.jpa.dto.CreateCourseRequestDto;
import com.enyoi.jpa.dto.GetCoursesResponseDto;
import com.enyoi.jpa.dto.TaskDto;
import com.enyoi.jpa.model.Course;
import com.enyoi.jpa.model.Task;
import com.enyoi.jpa.model.Teacher;
import com.enyoi.jpa.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class CourseService {

    private final CourseRepository courseRepository;

    @Transactional //CUMPLE ACID
    public List<GetCoursesResponseDto> getCourses(){
        List<Course> courses = courseRepository.findAll();
        return mapCourses(courses); //PUEDO ACCEDER A RECURSOS LAZY PORQUE LA SESIÓN SIGUE ABIERTA.
    }

    @Transactional //CUMPLE ACID
    public void saveNewCourse(CreateCourseRequestDto dto){
        //AQUI INICIA LA TRANSACCIÓN
        Course course = new Course();
        course.setName(dto.getName());
        course.setDescription(dto.getDescription());
        course.setTeacher(null);
        course.setTasks(new ArrayList<>());
        course.setCoursesStudents(new ArrayList<>());

        courseRepository.save(course); //EJECUTÉ

        throw new RuntimeException("ERROR PREMEDITADO");
    } //AQUI TERMINA LA TRANSACCIÓN


    private List<GetCoursesResponseDto> mapCourses(List<Course> courses){
        List<GetCoursesResponseDto> responseDtos = new ArrayList<>();
        for(Course course: courses){
            GetCoursesResponseDto dto = new GetCoursesResponseDto();
            dto.setId(course.getId());
            dto.setName(course.getName());
            dto.setDescription(course.getDescription());
            dto.setName(course.getName());
            dto.setTaskDtos(mapTasks(course.getTasks()));
            responseDtos.add(dto);
        }
        return responseDtos;
    }

    private List<TaskDto> mapTasks(List<Task> tasks){
        List<TaskDto> response = new ArrayList<>();
        for(Task task: tasks){
            TaskDto taskDto = new TaskDto();
            taskDto.setId(task.getId());
            taskDto.setTitle(task.getTitle());
            taskDto.setDescription(task.getDescription());
            taskDto.setPublicationDate(task.getPublicationDate());
            response.add(taskDto);
        }
        return response;
    }


}
