package com.github.glo2003.payroll;

public class HourlyEmployee extends Employee {
    private final float workedHoursFor2Weeks;
    private float hourlyRate;

    public HourlyEmployee(String name, String role, float hourlyRate, float workedHoursFor2Weeks) {
        super(name, role);
        this.hourlyRate = hourlyRate;
        this.workedHoursFor2Weeks = workedHoursFor2Weeks;
    }

    public float getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public float getWorkedHoursFor2Weeks() {
        return workedHoursFor2Weeks;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "name='" + this.getName() + '\'' +
                ", role='" + this.getRole() + '\'' +
                ", hourlyRate=" + hourlyRate +
                ", workedHoursFor2Weeks=" + workedHoursFor2Weeks +
                '}';
    }
}
