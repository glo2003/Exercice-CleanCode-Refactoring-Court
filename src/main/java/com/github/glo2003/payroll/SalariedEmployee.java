package com.github.glo2003.payroll;

public class SalariedEmployee extends Employee {
    private float monthly;

    public SalariedEmployee(String name, String role, int vacation_days, float monthly) {
        super(name, role, vacation_days);
        this.monthly = monthly;
    }

    public float getMonthly() {
        return monthly;
    }

    public void setMonthly(float monthly) {
        this.monthly = monthly;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" +
                "name='" + this.getName() + '\'' +
                ", role='" + this.getRole() + '\'' +
                ", vacation_days=" + this.getVacation_days() +
                ", monthly=" + monthly +
                '}';
    }
}
