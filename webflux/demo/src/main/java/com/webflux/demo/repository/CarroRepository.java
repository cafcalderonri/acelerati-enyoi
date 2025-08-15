package com.webflux.demo.repository;

import com.webflux.demo.entity.Carro;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface CarroRepository extends R2dbcRepository<Carro, Integer> {

    Flux<Carro> findByPersonaId(Integer personaId);

}
