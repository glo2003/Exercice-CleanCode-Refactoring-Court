package com.github.glo2003.payroll;

public class SalariedEmployee extends Employee {
    private float weeklySalary;

    public SalariedEmployee(String name, String role, int vacation_days, float weeklySalary) {
        super(name, role, vacation_days);
        this.weeklySalary = weeklySalary;
    }

    public float getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(float weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" +
                "name='" + this.getName() + '\'' +
                ", role='" + this.getRole() + '\'' +
                ", vacation_days=" + this.getVacation_days() +
                ", weeklySalary=" + weeklySalary +
                '}';
    }
}
