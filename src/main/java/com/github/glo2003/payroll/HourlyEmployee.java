package com.github.glo2003.payroll;

public class HourlyEmployee extends Employee {
    private float hourlyRate;
    private float amount;

    // TODO constructor

    public HourlyEmployee(String name, String role, int vacation_days, float hourlyRate, float amount) {
        super(name, role, vacation_days);
        this.hourlyRate = hourlyRate;
        this.amount = amount;
    }
}
