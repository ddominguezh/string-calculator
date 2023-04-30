package com.codurance.katalyst;

public class NegativesNotAllowedException extends RuntimeException {
    
    public NegativesNotAllowedException(String[] numbers){
        super("error: negatives not allowed: " + String.join(" ", numbers));
    }
}
