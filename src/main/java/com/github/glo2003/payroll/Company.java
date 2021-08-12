package com.github.glo2003.payroll;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Employee> employees;

    public Company() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> findSoftwareEngineers() {
        List<Employee> es = new ArrayList<>();
        for (int i = 1; i <= employees.size(); ++i) {
            if (employees.get(i - 1).getRole().equals("engineer")) {
                es.add(employees.get(i - 1));
            }
        }
        return es;
    }

    public List<Employee> findManagers() {
        List<Employee> es = new ArrayList<>();
        for (int i = 1; i <= employees.size(); ++i) {
            if (employees.get(i - 1).getRole().equals("engineer")) {
                es.add(employees.get(i - 1));
            }
        }
        return es;
    }

    public List<Employee> findVicePresidents() {
        List<Employee> es = new ArrayList<>();
        for (int i = 1; i <= employees.size(); ++i) {
            if (employees.get(i - 1).getRole().equals("engineer")) {
                es.add(employees.get(i - 1));
            }
        }
        return es;
    }

    public List<Employee> findInterns() {
        List<Employee> es = new ArrayList<>();
        for (int i = 1; i <= employees.size(); ++i) {
            if (employees.get(i - 1).getRole().equals("engineer")) {
                es.add(employees.get(i - 1));
            }
        }
        return es;
    }

    public void payEmployees() {

    }

    public void payEmployee(Employee employee) {
        if (employee instanceof HourlyEmployee) {

        } else if (employee instanceof  SalariedEmployee) {

        }
    }

    public float getNextPayCost() {
        return 0;
    }

    public float getAveragePay() {
        return 0;
    }
}
