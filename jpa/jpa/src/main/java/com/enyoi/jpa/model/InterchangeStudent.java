package com.enyoi.jpa.model;

public class InterchangeStudent extends Student{

    //NO PUEDE MATRICULAR
    @Override
    public void matricular(Course course){
        throw new RuntimeException("UN ESTUDIANTE DE INTERCAMBIO NO PUEDE MATRICULAR");
    }


}
