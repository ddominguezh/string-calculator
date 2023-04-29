package com.codurance.katalyst;

public class StringCalculator {

    public Integer add(String numbers) {
        if("".equals(numbers)){
            return 0;
        }
        return Integer.parseInt(numbers);
    }
    
}
