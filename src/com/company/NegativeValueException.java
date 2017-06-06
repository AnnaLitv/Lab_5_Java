package com.company;


public class NegativeValueException extends Exception {
    public NegativeValueException(String propertyName){
        initCause(new Throwable("Property " + propertyName + " is negative!"));
    }
}
