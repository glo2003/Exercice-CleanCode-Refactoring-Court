package com.github.glo2003;

import com.github.glo2003.payroll.Company;
import com.github.glo2003.payroll.Employee;
import com.github.glo2003.payroll.HourlyEmployee;
import com.github.glo2003.payroll.SalariedEmployee;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Company company = new Company();

        company.addEmployee(new HourlyEmployee("Alice", "vp", 25, 100, 35.5f));
        company.addEmployee(new SalariedEmployee("Bob", "engineer", 10, 1500));
        company.addEmployee(new SalariedEmployee("Charlie", "manager", 10, 2000));
        company.addEmployee(new HourlyEmployee("Ernest", "intern", 10, 5, 50));
        company.addEmployee(new HourlyEmployee("Fred", "intern", 10, 5, 50));

        System.out.println("----- Listing employees -----");
        company.listEmployees();

        System.out.println("\n----- Paying employees -----");
        company.payEmployees();

        System.out.println("\n----- Pay statistics -----");
        /*
        public float computeTotal() {
            return 0;
        }

        public float getAveragePay() {
            return 0;
        }
         */

        System.out.println("\n----- Holidays -----");
    }

}
