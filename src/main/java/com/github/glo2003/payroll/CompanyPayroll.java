package com.github.glo2003.payroll;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyPayroll {
    final private List<Employee> employees;
    private final List<Paycheck> pendingPaychecks;

    public CompanyPayroll() {
        employees = new ArrayList<>();
        pendingPaychecks = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void createPendingPaychecks() {
        for (Employee e : employees) {
            if (e instanceof HourlyEmployee) {
                HourlyEmployee he = (HourlyEmployee) e;
                pendingPaychecks.add(new Paycheck(e.getName(), he.getWorkedHoursFor2Weeks() * he.getHourlyRate()));
            } else if (e instanceof SalariedEmployee) {
                SalariedEmployee se = (SalariedEmployee) e;
                pendingPaychecks.add(new Paycheck(e.getName(), ((SalariedEmployee) e).getBiweeklySalary()));
            } else {
                throw new RuntimeException("something happened");
            }
        }
    }

    public void processPendingPaychecks() {
        for (Paycheck p : pendingPaychecks) {
            System.out.println("Sending " + p.getAmount() + "$ to " + p.getTo());
        }
        pendingPaychecks.clear();
    }

    public List<Employee> findEngineers() {
        return findByRole("engineer");
    }

    public List<Employee> findManagers() {
        return findByRole("manager");
    }

    public List<Employee> findVicePresidents() {
        return findByRole("vp");
    }

    public List<Employee> findInterns() {
        return findByRole("intern");
    }

    private List<Employee> findByRole(String role) {
        return employees.stream()
                .filter(e -> e.getRole().equals(role))
                .collect(Collectors.toList());
    }

    public void giveRaise(Employee e, float raise) {
        if (raise < 0) {
            throw new RuntimeException("oh no");
        }
        if (!employees.contains(e)) {
            throw new RuntimeException("not here");
        }
        if (e instanceof HourlyEmployee) {
            HourlyEmployee he = (HourlyEmployee) e;
            he.setHourlyRate(he.getHourlyRate() + raise);
        } else if (e instanceof SalariedEmployee) {
            SalariedEmployee se = (SalariedEmployee) e;
            se.setBiweeklySalary(se.getBiweeklySalary() + raise);
        } else {
            throw new RuntimeException("something happened");
        }
    }

    public float getAveragePendingPaycheck() throws Exception {
        if (pendingPaychecks.size() == 0) {
            throw new Exception("There is no employee");
        }
        float totalMoney = getTotalMoney();
        return totalMoney / pendingPaychecks.size();
    }

    public float getTotalMoney() {
        return pendingPaychecks.stream()
                .map(Paycheck::getAmount)
                .reduce(0.f, Float::sum);
    }

    public List<Paycheck> getPendings() {
        return pendingPaychecks;
    }
}
