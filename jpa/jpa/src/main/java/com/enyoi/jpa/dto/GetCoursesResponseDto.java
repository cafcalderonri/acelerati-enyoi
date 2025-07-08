package com.enyoi.jpa.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetCoursesResponseDto {

    private Integer id;
    private String teacherName;
    private String name;
    private String description;
    private List<TaskDto> taskDtos;
}
