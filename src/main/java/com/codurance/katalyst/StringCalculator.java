package com.codurance.katalyst;

import java.util.Arrays;

public class StringCalculator {

    public Integer add(String numbers) {
        if("".equals(numbers)){
            return 0;
        }

        String[] values = numbers.split(",", -1);
        if(values.length == 1){
            return Integer.valueOf(values[0]);
        }
        return Integer.valueOf(values[0]) + Integer.valueOf(values[1]);
    }
    
}
