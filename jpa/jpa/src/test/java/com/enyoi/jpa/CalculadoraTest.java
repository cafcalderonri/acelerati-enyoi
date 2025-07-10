package com.enyoi.jpa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraTest {

    Calculadora calculadora = new Calculadora("CASIO", 30);


    @Test
    void probarSuma(){
        //ARRANGE
        int numeroUno = 3;
        int numeroDos = 5;
        int expectedResponse = 8;

        //ACT
        int actualResponse = calculadora.sumar(numeroUno, numeroDos);

        //ASSERT
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void probarMultiplicacion(){
        //ARRANGE
        int numeroUno = getTwo();
        int numeroDos = getThree();
        int expectedResponse = 6;

        //ACT
        int actualResponse = calculadora.multiplicar(numeroUno, numeroDos);

        //ASSERT
        assertEquals(expectedResponse, actualResponse);

    }

    private int getTwo(){
        return 2;
    }

    private int getThree(){
        return 3;
    }


}
