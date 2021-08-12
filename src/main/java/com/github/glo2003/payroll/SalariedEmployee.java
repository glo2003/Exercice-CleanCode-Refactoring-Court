package com.github.glo2003.payroll;

public class SalariedEmployee extends Employee {
    private int weeklySalary;

    public SalariedEmployee(String name, String role, int vacation_days, int weeklySalary) {
        super(name, role, vacation_days);
        this.weeklySalary = weeklySalary;
    }
}
