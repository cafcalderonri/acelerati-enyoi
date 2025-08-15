package com.webflux.demo.controller;

import com.webflux.demo.entity.Persona;
import com.webflux.demo.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/v1/persona")
@RequiredArgsConstructor
public class PersonaController {

    private final PersonaService personaService;

    @PostMapping
    public Mono<Persona> savePersona(@RequestBody Persona persona){
        return personaService.savePersona(persona);
    }

    @PostMapping("/all")
    public Flux<Persona> savePersonas(@RequestBody Flux<Persona> personas){
        return personaService.savePersonas(personas);
    }

    @GetMapping("/edad/{edad}")
    public Flux<Persona> getPersonasByEdad(@PathVariable("edad") Integer edad){
        return personaService.getPersonasByEdad(Mono.just(edad));
    }

    @PostMapping("/nombres")
    public Flux<Persona> getPersonasByNombre(@RequestBody List<Integer> ids){
        return personaService.getPersonasByNames(Flux.fromIterable(ids));
    }


}
