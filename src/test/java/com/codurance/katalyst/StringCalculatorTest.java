package com.codurance.katalyst;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    
    @Test
    public void add_when_string_is_empty(){
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    } 

    @Test
    public void add_when_string_contains_only_one_number(){
        StringCalculator calculator = new StringCalculator();
        assertEquals(5, calculator.add("5"));
    }

    @Test
    public void add_when_string_contains_two_numbers(){
        StringCalculator calculator = new StringCalculator();
        assertEquals(53, calculator.add("4,49"));
    }
}
