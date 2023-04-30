package com.codurance.katalyst;

import java.util.Arrays;

public class StringCalculator {

    private static final String DEFAULT_SEPARATOR = "[\\n|,]";
    
    public Integer add(String numbers) {
        if("".equals(numbers)){
            return 0;
        }
        return Arrays.stream(numbers.split(DEFAULT_SEPARATOR, -1))
            .map(number -> Integer.valueOf(number))
            .reduce(0, (a, b) -> a + b);
    }
    
}
