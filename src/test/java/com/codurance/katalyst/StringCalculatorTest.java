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

    @Test
    public void add_when_string_contains_many_numbers(){
        StringCalculator calculator = new StringCalculator();
        assertEquals(55, calculator.add("3,5,10,5,2,30"));
    }

    @Test
    public void add_when_string_contains_new_lines_separator(){
        StringCalculator calculator = new StringCalculator();
        assertEquals(55, calculator.add("3,5\n10,5,2\n30"));
    }

    @Test
    public void add_when_string_contains_custom_separator(){
        StringCalculator calculator = new StringCalculator();
        assertEquals(55, calculator.add("//;\n3;5;10;5;2;30"));
    }
}
