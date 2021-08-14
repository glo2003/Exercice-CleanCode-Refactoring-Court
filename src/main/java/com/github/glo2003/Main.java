package com.github.glo2003;

import com.github.glo2003.payroll.CompanyPayroll;
import com.github.glo2003.payroll.HourlyEmployee;
import com.github.glo2003.payroll.SalariedEmployee;

public class Main {

    public static void main(String[] args) {
        CompanyPayroll companyPayroll = new CompanyPayroll();

        companyPayroll.addEmp(new HourlyEmployee("Alice", "vp", 25, 100, 35.5f));
        companyPayroll.addEmp(new SalariedEmployee("Bob", "engineer", 10, 1500));
        companyPayroll.addEmp(new SalariedEmployee("Charlie", "manager", 10, 2000));
        companyPayroll.addEmp(new HourlyEmployee("Ernest", "intern", 10, 5, 50));
        companyPayroll.addEmp(new HourlyEmployee("Fred", "intern", 10, 5, 50));

        System.out.println("----- Listing employees -----");
        companyPayroll.listEmployees();

        System.out.println("\n----- Paying employees -----");
        companyPayroll.payEmployees();

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
