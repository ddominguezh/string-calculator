package com.codurance.katalyst;

import java.util.Arrays;

public class StringCalculator {

    public Integer add(String numbers) {
        if("".equals(numbers)){
            return 0;
        }
        return Arrays.stream(numbers.split("[\\n|,]", -1))
            .map(number -> Integer.valueOf(number))
            .reduce(0, (a, b) -> a + b);
    }
    
}
