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

    public float getHourlyRate() {
        return hourlyRate;
    }

    public float getAmount() {
        return amount;
    }

    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "name='" + this.getName() + '\'' +
                ", role='" + this.getRole() + '\'' +
                ", vacation_days=" + this.getVacation_days() +
                ", hourlyRate=" + hourlyRate +
                ", amount=" + amount +
                '}';
    }
}
