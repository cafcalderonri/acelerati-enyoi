package com.enyoi.jpa.utilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringUtilTest {

    @Test
    void testEliminarEspacios(){
        //ARRANGE
        String input = "Hola mundo !";
        String expectedOutput = "Holamundo!";

        //ACT
        String actualResponse = StringUtil.eliminarEspacios(input);

        //ASSERT
        assertEquals(expectedOutput, actualResponse);
    }


}
