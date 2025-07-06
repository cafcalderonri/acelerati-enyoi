package com.enyoi.jpa.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TaskDto {

    private Integer id;
    private String title;
    private String description;
    private LocalDate publicationDate;
}
