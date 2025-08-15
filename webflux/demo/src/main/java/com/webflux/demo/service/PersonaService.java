package com.webflux.demo.service;

import com.webflux.demo.dto.response.PersonaConCarrosDto;
import com.webflux.demo.entity.Carro;
import com.webflux.demo.entity.Persona;
import com.webflux.demo.repository.CarroRepository;
import com.webflux.demo.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaService {

    private final PersonaRepository personaRepository;
    private final CarroRepository carroRepository;

    public Mono<Persona> savePersona(Persona persona){
        return personaRepository.save(persona);
    }

    public Flux<Persona> savePersonas(Flux<Persona> personas){
        return personaRepository.saveAll(personas);
    }

    public Flux<Persona> getPersonasByEdad(Mono<Integer> emisorDeEdad){
        return personaRepository.findByEdad(emisorDeEdad);
    }

    public Flux<Persona> getPersonasByNames(Flux<Integer> emisorDeIds){
        return emisorDeIds.flatMap( //TENGO UN FLUX<INTEGER> como input
                id -> personaRepository.findById(Mono.just(id)) //DEVUELVO FLUX<Persona>
        );
    }

    public Mono<PersonaConCarrosDto> getPersonaConCarrosByIdPersona(Integer personaId){
        return personaRepository.findById(personaId) //MONO<Persona>
                .flatMap(persona -> { //MONO<Persona> --> Mono<PersonaConCarros>
                             Flux<Carro> carroFlux = carroRepository.findByPersonaId(persona.getId()); //FLUX<Carro>
                             return Mono.just(mapPersonaCarros(persona, carroFlux)); // Retorno un nuevo publicador --> Mono<PersonaConCarros>
                        });
    }

    //MAPEO PARA CREAR EL DTO NUEVO
    private PersonaConCarrosDto mapPersonaCarros(Persona persona, Flux<Carro> carroFlux){
        PersonaConCarrosDto dto = new PersonaConCarrosDto();
        dto.setCarros(carroFlux);
        dto.setPersona(persona);
        return dto;
    }

}
