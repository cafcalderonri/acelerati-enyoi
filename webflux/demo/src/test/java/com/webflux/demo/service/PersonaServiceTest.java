package com.webflux.demo.service;

import com.webflux.demo.entity.Persona;
import com.webflux.demo.repository.PersonaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonaServiceTest {

    @Mock
    private PersonaRepository personaRepository;

    @InjectMocks
    private PersonaService personaService;


    @Test
    void testGetPersonasByEdad(){

        Persona persona = new Persona();
        persona.setId(3);
        persona.setNombre("test");
        persona.setEdad(30);
        Mono<Integer> emisorDeEdad = Mono.just(30);

        when(personaRepository.findByEdad(emisorDeEdad)).thenReturn(Flux.just(persona));

        Flux<Persona> response = personaService.getPersonasByEdad(emisorDeEdad);

        StepVerifier.create(response)
                .expectNextMatches(persona1 -> persona1.getNombre().equals("test"))
                .expectComplete()
                .verify();
        
    }


}
