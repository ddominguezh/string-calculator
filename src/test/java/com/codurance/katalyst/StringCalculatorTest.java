package com.codurance.katalyst;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    public void disallow_negatives(){
        StringCalculator calculator = new StringCalculator();
        Throwable exception = assertThrows(NegativesNotAllowedException.class, () -> {
            calculator.add("1,-2,-3");
        });
        assertEquals("error: negatives not allowed: -2 -3", exception.getMessage());
    }

    @Test
    public void ignore_numbers_bigger_than_1000(){
        StringCalculator calculator = new StringCalculator();
        assertEquals(2, calculator.add("1001,2"));
    }

    @Test
    public void arbitrary_length_separators(){
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("//[\\*\\*\\*]\n1***2***3"));
    }

    @Test
    public void multiple_single_length_separators(){
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("//[\\*][%]\n1*2%3"));
    }

    @Test
    public void multiple_longer_length_separators(){
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("//[foo][bar]\n1foo2bar3"));
    }
}
