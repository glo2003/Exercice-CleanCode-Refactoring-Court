package com.github.glo2003.payroll.employees;

import com.github.glo2003.payroll.Role;

public class HourlyEmployee extends Employee {
    private final float workedHoursFor2Weeks;
    private float hourlyRate;

    public HourlyEmployee(String name, Role role, float hourlyRate, float workedHoursFor2Weeks) {
        super(name, role);
        this.hourlyRate = hourlyRate;
        this.workedHoursFor2Weeks = workedHoursFor2Weeks;
    }

    @Override
    public float getPayForTwoWeeks() {
        return workedHoursFor2Weeks * hourlyRate;
    }

    @Override
    public void giveRaise(float raise) {
        hourlyRate += raise;
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
