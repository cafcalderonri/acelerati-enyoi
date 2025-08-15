package com.webflux.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("PERSONAS")
@Getter
@Setter
public class Persona {

    @Id
    private Integer id;

    private String nombre;

    private Integer edad;

}
