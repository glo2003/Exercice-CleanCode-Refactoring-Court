package com.github.glo2003.payroll.exceptions;

public class NoEmployeeException extends Exception {
    public NoEmployeeException() {
        super("There is no employee here!");
    }
}
