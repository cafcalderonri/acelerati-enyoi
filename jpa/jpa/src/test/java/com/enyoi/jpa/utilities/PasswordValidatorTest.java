package com.enyoi.jpa.utilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordValidatorTest {

    PasswordValidator passwordValidator = new PasswordValidator();

    @Test
    void deberiaValidarQueElPasswordTengaMenosDeDoceCaracteresYMasDeCincoCaracteres(){
        //ARRANGE
        String input1 = "123";
        String input2 = "12345678";
        String input3 = "123456789abcdef";

        //ACT
        boolean response1 = passwordValidator.validarPassword(input1);
        boolean response2 = passwordValidator.validarPassword(input2);
        boolean response3 = passwordValidator.validarPassword(input3);

        //ASSERT
        assertFalse(response1);
        assertTrue(response2); //CUMPLE Y LOS DEMAS FALSO
        assertFalse(response3);
    }



}
