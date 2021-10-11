package com.github.glo2003.payroll.exceptions;

public class InvalidRaiseException extends Exception {
    public InvalidRaiseException(float raise) {
        super("Raise " + raise + " is invalid");
    }
}
