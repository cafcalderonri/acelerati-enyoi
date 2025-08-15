package com.webflux.demo.dto.response;

import com.webflux.demo.entity.Carro;
import com.webflux.demo.entity.Persona;
import lombok.Getter;
import lombok.Setter;
import reactor.core.publisher.Flux;

@Getter
@Setter
public class PersonaConCarrosDto {

    private Persona persona;
    private Flux<Carro> carros;


}
