package com.github.glo2003.payroll;

import com.github.glo2003.payroll.employees.Employee;
import com.github.glo2003.payroll.exceptions.EmployeeDoesNotWorkHereException;
import com.github.glo2003.payroll.exceptions.InvalidRaiseException;
import com.github.glo2003.payroll.exceptions.NoEmployeeException;

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
            float payForTwoWeeks = e.getPayForTwoWeeks();
            if (payForTwoWeeks > 0) {
                pendingPaychecks.add(new Paycheck(e.getName(), payForTwoWeeks));
            }
        }
    }

    public void processPendingPaychecks() {
        for (Paycheck p : pendingPaychecks) {
            System.out.println("Sending " + p.getAmount() + "$ to " + p.getTo());
        }
        pendingPaychecks.clear();
    }

    public List<Employee> findVicePresidents() {
        return findByRole(Role.VICE_PRESIDENT);
    }

    public List<Employee> findManagers() {
        return findByRole(Role.MANAGER);
    }

    public List<Employee> findEngineers() {
        return findByRole(Role.ENGINEER);
    }

    public List<Employee> findInterns() {
        return findByRole(Role.INTERN);
    }

    private List<Employee> findByRole(Role role) {
        return employees.stream()
                .filter(e -> e.getRole().equals(role))
                .collect(Collectors.toList());
    }

    public void giveRaise(Employee e, float raise) throws InvalidRaiseException, EmployeeDoesNotWorkHereException {
        if (raise < 0) {
            throw new InvalidRaiseException(raise);
        }
        if (!employees.contains(e)) {
            throw new EmployeeDoesNotWorkHereException(e);
        }
        e.giveRaise(raise);
    }

    public float getAveragePendingPaycheck() throws Exception {
        if (pendingPaychecks.size() == 0) {
            throw new NoEmployeeException();
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
