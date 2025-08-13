package org.example;

import reactor.core.publisher.Mono;

public class Main {
    public static void main(String[] args) {

        publicadorDeSaludosDeNombre("Carlos").subscribe(
               nombre -> System.out.println(nombre)
       );


    }

    //FLATMAP --> APLANAR (Obtener lo que tenga adentro) del publicador --- LUEGO GENERO OTRO PUBLICADOR
    public static Mono<String> publicadorDeSaludosDeNombre(String nombre){
        return publicadorDeSaludos().flatMap(str -> Mono.just(str + " " + nombre)); //NECESITO ACCEDER A LOS DATOS DEL PUBLICADOR Y DEVOLVER OTRO PUBLICADOR --- Concantenar un nombre
    }

    public static Mono<String> publicadorDeSaludos(){
        return Mono.just("Hola");
    }

    public static String saludo(){
        return "Hola";
    }

}