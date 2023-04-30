package com.codurance.katalyst;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
    private static final int MAX_VALID_NUMBER = 1000;

    public Integer add(String numbers) {
        if("".equals(numbers)){
            return 0;
        }
        Matcher matcher = Pattern.compile("-{0,1}[0-9]+").matcher(numbers);
        List<Integer> values = matcher.results().map(result -> Integer.valueOf(result.group())).collect(Collectors.toList());
        if(containsNegativesNumbers(values)){
            throw new NegativesNotAllowedException(extractNegativesNumbers(values));
        }
        return values.stream().filter(number -> number <= MAX_VALID_NUMBER).reduce(0, (a, b) -> a + b);
    }
    
    private boolean containsNegativesNumbers(List<Integer> values) {
        return values.stream()
                .anyMatch(value -> value < 0);
    }

    private String[] extractNegativesNumbers(List<Integer> values) {
        return values.stream()
                .filter(value -> value < 0)
                .map(value -> value.toString())
                .toArray(String[]::new);
    }

}
