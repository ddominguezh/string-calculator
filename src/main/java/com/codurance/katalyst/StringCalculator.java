package com.codurance.katalyst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {

    private static final String DEFAULT_SEPARATOR = "[\\n|,]";
    private static final int MAX_VALID_NUMBER = 1000;

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
        return values.stream().filter(number -> number <= MAX_VALID_NUMBER).reduce(0, (a, b) -> a + b);
    }

    private boolean containsCustomSeparator(String numbers){
        return Pattern.compile("^[(\\/\\/.\\n)]").matcher(numbers).find();
    }

    private String extractCustomSeparator(String numbers){
        String customSeparator = numbers.substring(numbers.indexOf("//")+2, numbers.indexOf("\n"));
        List<String> separators = new ArrayList<String>();
        while(customSeparator.indexOf("]") != -1){
            String separator = customSeparator.substring(customSeparator.indexOf("[")+1, customSeparator.indexOf("]"));
            separators.add(separator);
            customSeparator = customSeparator.substring(customSeparator.indexOf("]")+1);
        }
        if(separators.size() > 1){
            return "[" + String.join("|" , separators.toArray(new String[0])) + "]";
        }else if(separators.size() == 1){
            return separators.get(0);
        }
        return customSeparator;
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
