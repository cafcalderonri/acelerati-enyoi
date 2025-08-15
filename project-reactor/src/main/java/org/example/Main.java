package org.example;

import reactor.core.publisher.Mono;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        publicadorDeSaludos("Jose").subscribe(System.out::println);


    }



   public static Mono<String> publicadorDeSaludos(String nombre){
        return publicadorDeHolaMundo().flatMap( //TOMO ESTE MONO<STRING> y lo destruyo --> hago algo y devuelvo un nuevo publicaror
                str -> Mono.just(str + " " + nombre)
        );
   }


   //DEVUELVE UN MONO<STRING>
   public static Mono<String> publicadorDeHolaMundo(){
        return Mono.just("Hola mundo!");
   }

   //DEVUELVE UN STRING
   public static String saludar(){
        return "hola mundo!";
   }




}