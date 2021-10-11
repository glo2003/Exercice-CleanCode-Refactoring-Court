package com.github.glo2003.payroll.exceptions;

import com.github.glo2003.payroll.employees.Employee;

public class EmployeeDoesNotWorkHereException extends Exception {
    public EmployeeDoesNotWorkHereException(Employee e) {
        super("Employee " + e.getName() + " does not work here...");
    }
}
