package com.example.utility;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ControllerTest {

    @Test
    @DisplayName("This is my test case name")
    public void testSayHi(){
        String hit = "Hitesh";

//        assertTrue(hit.equals("Jk"));
        Assertions.assertThat(hit).isEqualTo("Hitesh");

    }
}
