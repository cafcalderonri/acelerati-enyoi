package com.webflux.demo.controller;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

class TestControllerTest {

    TestController testController = new TestController();


    @Test
    void testEmisorDeNumeros(){
        //TOMAR EL PUBLISHER QUE DESEAMOS PROBAR
        Flux<Integer> emisorDeNumeros = testController.emitirNumeros(); //PUBLICADOR

        StepVerifier.create(emisorDeNumeros)
                .expectNext(1)
                .expectNext(2)
                .expectNext(3)
                .expectNext(4)
                .expectNext(5)
                .expectComplete()
                .verify(); //SUSCRIPCIÓN

    }


}
