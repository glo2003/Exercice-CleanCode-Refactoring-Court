package com.github.glo2003.payroll;

import java.util.ArrayList;
import java.util.List;

//// Company class
public class Company {
    // private attributes
    private List<Employee> employees;
    private List<Paycheck> pending;

    //  constructor
    public Company() {
        this.employees = new ArrayList<>();
        this.pending = new ArrayList<>();
    }

    public void processPending() {
        for (int i = 1; i <= this.pending.size(); ++i) {
            Paycheck p = this.pending.get(i - 1);
            System.out.println("Sending " + p.getAmount() + "$ to " + p.getTo());
        }
        this.pending.clear();
    }

    /***
     * add employee
     * @param employee: employee to add
     */
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // TODO fire employee

    /***
     * find
     * @return found
     */
    public List<Employee> findSoftwareEngineers() {
        List<Employee> es = new ArrayList<>();
        for (int i = 1; i <= employees.size(); ++i) {
            if (employees.get(i - 1).getRole().equals("engineer")) {
                es.add(employees.get(i - 1));
            }
        }
        return es;
    }

    /***
     * todo
     * @return
     */
    public List<Employee> findManagers() {
        List<Employee> es = new ArrayList<>();
        for (int i = 1; i <= employees.size(); ++i) {
            if (employees.get(i - 1).getRole().equals("manager")) {
                es.add(employees.get(i - 1));
            }
        }
        return es;
    }

    /**/
    public List<Employee> findVicePresidents() {
        List<Employee> es = new ArrayList<>();
        for (int i = 1; i <= employees.size(); ++i) {
            if (employees.get(i - 1).getRole().equals("vp")) {
                es.add(employees.get(i - 1));
            }
        }
        return es;
    }

    public List<Employee> findInterns() {
        List<Employee> es = new ArrayList<>();
        for (int i = 1; i <= employees.size(); ++i) {
            if (employees.get(i - 1).getRole().equals("intern")) {
                es.add(employees.get(i - 1));
            }
        }
        return es;
    }

    public void listEmployees() {
        List<Employee> vps = this.findVicePresidents();
        System.out.println("Vice presidents:");
        vps.forEach(e -> System.out.println("\t" + e.toString()));

        List<Employee> engineers = new ArrayList<>();
        for (int i = 1; i <= employees.size(); ++i) {
            if (employees.get(i - 1).getRole().equals("engineer")) {
                engineers.add(employees.get(i - 1));
            }
        }
        System.out.println("Software Engineers:");
        engineers.forEach(e -> System.out.println("\t" + e.toString()));

        List<Employee> managers = new ArrayList<>();
        for (int i = 1; i <= employees.size(); ++i) {
            if (employees.get(i - 1).getRole().equals("manager")) {
                managers.add(employees.get(i - 1));
            }
        }
        System.out.println("Managers:");
        managers.forEach(e -> System.out.println("\t" + e.toString()));

        List<Employee> interns = this.findInterns();
        for (int i = 1; i <= employees.size(); ++i) {
            if (employees.get(i - 1).getRole().equals("intern")) {
                interns.add(employees.get(i - 1));
            }
        }
        System.out.println("Interns:");
        interns.forEach(e -> System.out.println("\t" + e.toString()));
    }

    public void createPending() {
        for (int i = 1; i <= employees.size(); ++i) {
            Employee e = employees.get(i - 1);
            if (e instanceof HourlyEmployee) {
                HourlyEmployee he = (HourlyEmployee)e;
                System.out.println("Paying " + e.getName() + " " + he.getHourlyRate()
                        + "$ per hour for " + he.getAmount() + " hours. Paying a total of " + he.getHourlyRate() * he.getAmount());
            } else if (e instanceof  SalariedEmployee) {
                SalariedEmployee se = (SalariedEmployee)e;
                System.out.println("Paying " + e.getName() + " a weekly salary of " + se.getWeeklySalary() + "$.");
            } else {
                throw new RuntimeException("something happened");
            }
        }
    }

    public void giveRaise(Employee e, float raise) {
        if (raise < 0) {
            throw new RuntimeException("oh no");
        }

        if (e instanceof HourlyEmployee) {
            HourlyEmployee he = (HourlyEmployee)e;
            he.setHourlyRate(he.getHourlyRate() + raise);
        } else if (e instanceof  SalariedEmployee) {
            SalariedEmployee se = (SalariedEmployee)e;
            se.setWeeklySalary(se.getWeeklySalary() + raise);
        } else {
            throw new RuntimeException("something happened");
        }
    }

    public void takeHoliday(Employee e, boolean payout) {
        if (e instanceof HourlyEmployee) {
            HourlyEmployee he = (HourlyEmployee)e;
        } else if (e instanceof  SalariedEmployee) {
            SalariedEmployee se = (SalariedEmployee)e;
            se.setWeeklySalary(se.getWeeklySalary() + raise);
        } else {
            throw new RuntimeException("something happened");
        }
    }

}
