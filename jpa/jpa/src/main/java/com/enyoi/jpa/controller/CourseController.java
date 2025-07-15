package com.enyoi.jpa.controller;

import com.enyoi.jpa.dto.CreateCourseRequestDto;
import com.enyoi.jpa.dto.GetCoursesResponseDto;
import com.enyoi.jpa.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService; //CONCRETO

    @GetMapping
    public ResponseEntity<List<GetCoursesResponseDto>> getAllCourses(){
        List<GetCoursesResponseDto> courses = courseService.getCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> saveNewCourse(@RequestBody CreateCourseRequestDto dto){
        try{
            courseService.saveNewCourse(dto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
