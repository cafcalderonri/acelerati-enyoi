package com.webflux.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("CARROS")
@Getter
@Setter
public class Carro {

    @Id
    private Integer id;

    private String marca;

    @Column("persona_id")
    private Integer personaId;
}
