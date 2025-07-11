package com.enyoi.jpa.utilities;

public class StringUtil {

    private StringUtil(){}

    public static String eliminarEspacios(String stringConEspacios){
        return stringConEspacios.replaceAll(" ", "");
    }



}
