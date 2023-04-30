package com.codurance.katalyst;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    private static final String DEFAULT_SEPARATOR = "[\\n|,]";

    public Integer add(String numbers) {
        if("".equals(numbers)){
            return 0;
        }
        String separator = DEFAULT_SEPARATOR;
        if(containsCustomSeparator(numbers)){
            separator = extractCustomSeparator(numbers);
            numbers = removeCustomSeparator(numbers);
        }
        List<Integer> values = Arrays.stream(numbers.split(separator, -1))
                                .map(number -> Integer.valueOf(number))
                                .collect(Collectors.toList());
        if(containsNegativesNumbers(values)){
            throw new NegativesNotAllowedException(extractNegativesNumbers(values));
        }
        return values.stream().reduce(0, (a, b) -> a + b);
    }

    private boolean containsCustomSeparator(String numbers){
        return Pattern.compile("^[(\\/\\/.\\n)]").matcher(numbers).find();
    }

    private String extractCustomSeparator(String numbers){
        return numbers.substring(numbers.indexOf("//")+2, numbers.indexOf("\n"));
    }

    private String removeCustomSeparator(String numbers){
        return numbers.substring(numbers.indexOf("\n")+1);
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
