package com.codurance.katalyst;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    
    @Test
    public void add_when_string_is_empty(){
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    } 
}
