package com.github.glo2003.payroll.employees;

import com.github.glo2003.payroll.Role;

public class SalariedEmployee extends Employee {
    private float biweeklySalary;

    public SalariedEmployee(String name, Role role, float biweeklySalary) {
        super(name, role);
        this.biweeklySalary = biweeklySalary;
    }

    @Override
    public float getPayForTwoWeeks() {
        return biweeklySalary;
    }

    @Override
    public void giveRaise(float raise) {
        biweeklySalary += raise;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" +
                "name='" + this.getName() + '\'' +
                ", role='" + this.getRole() + '\'' +
                ", biweeklySalary=" + biweeklySalary +
                '}';
    }
}
