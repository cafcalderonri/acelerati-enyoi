package com.enyoi.jpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Calculadora {

    private String marca;
    private int horasDeCarga;

    public static int sumarEstatico(int a, int b){
        return a + b;
    }

    public int sumar(int a, int b){
        return a+b;
    }

    public int multiplicar(int a, int b){
        return a*b;
    }


}
