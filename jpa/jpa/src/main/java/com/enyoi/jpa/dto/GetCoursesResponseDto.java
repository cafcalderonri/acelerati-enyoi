package com.enyoi.jpa.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetCoursesResponseDto {

    private Integer id;
    private String teacherName;
    private String name;
    private String description;
    private TaskDto task;
}
