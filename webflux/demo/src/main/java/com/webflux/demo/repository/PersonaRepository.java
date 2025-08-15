package com.webflux.demo.repository;

import com.webflux.demo.entity.Persona;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonaRepository extends ReactiveCrudRepository<Persona, Integer> {

    Flux<Persona> findByEdad(Mono<Integer> edad);


}
