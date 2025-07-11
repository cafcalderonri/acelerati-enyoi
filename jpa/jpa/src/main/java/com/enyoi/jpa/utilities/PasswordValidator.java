package com.enyoi.jpa.utilities;

public class PasswordValidator {

    public boolean validarPassword(String input){
        int size = input.length();
        return size > 5 && size < 12;
    }


}
