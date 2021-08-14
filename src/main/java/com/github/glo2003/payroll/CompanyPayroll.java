package com.github.glo2003.payroll;

import java.util.ArrayList;
import java.util.List;

//// Company class
public class CompanyPayroll {




    // private attributes
    final private List<Employee> eList;
    private List<Paycheck>       p;

    //  constructor
    public CompanyPayroll() {
        this.eList = new ArrayList<>();
        this.p     = new ArrayList<>();
    }




    // process pending
    public void processPending() {
        for (int i=1; i  <= this.p.size(); ++i) { // iterate over all employees
            Paycheck p = this.p.get((i)--);
            System.out.println("Sending " + p.getAmount() + "$ to " + p.getTo());
        }this.p.clear();
    }


    /***
     * add employee
     * @param employee: employee to add
     */
    public void addEmp(Employee employee) {
        eList.add(employee);

    }

    /***
     * find
     * @return found
     */
    public List<Employee> findSWE() { // software engineer

        List<Employee> es = new ArrayList<>();
        for (int i = 1; i <= eList.size(); ++i) {

            if (eList.get(i - 1).getRole().equals("engineer")) {
                es.add(eList.get(i - 1));
            }


        }
        return es;


    }

    /***
     * todo
     * @return
     */
    public List<Employee> findMgs() { // find managers

        List<Employee> es = new ArrayList<>();
        for (int i = 1; i <= eList.size(); ++i) {
            if (eList.get(i - 1).getRole().equals("manager")) {
                es.add(eList.get(i - 1));
            }
        }
        return es;
    }

    /*
    public void test1() {
        this.findManagers();
        this.pay();
        this.fire(e);
    }
    */



    /**/
    public List<Employee> find_Vice_Presidents() {
        List<Employee> es = new ArrayList<>();
        for (int i = 1; i <= eList.size(); ++i) {
            if (eList.get(i - 1).getRole().equals("vp")) {
                es.add(eList.get(i - 1));
            }
        }
        return es;
    }
    // insert documentation here
    public List<Employee> find_interns() {  // snake case is better
        List<Employee> es = new ArrayList<>();
        for (int i = 1; i <= eList.size(); ++i) {
            if (eList.get(i - 1).getRole().equals("intern")) {
                es.add(eList.get(i - 1));
            }
        }
        return es;
    }





    // list employees
    public void listEmployees() {
        // TODO clean up
        List<Employee> vps = this.find_Vice_Presidents();
        System.out.println("Vice presidents:");
        for (Employee vp : vps) {
            System.out.println("\t" + vp.toString());
        }

        List<Employee> engs = this.findSWE()
        System.out.println("Software Engineers:");
        engs.forEach(e -> System.out.println("\t" + e.toString()));

        List<Employee> ms = new ArrayList<>();
        for (int i = 1; i <= eList.size(); ++i) {
            if (eList.get(i - 1).getRole().equals("manager")) {
                ms.add(eList.get(i - 1));
            }
        }
        System.out.println("Managers:");
        ms.forEach(e -> System.out.println("\t" + e.toString()));

        List<Employee> is = this.find_interns();
        for (int i = 1; i <= eList.size(); ++i) {
            if (eList.get(i - 1).getRole().equals("intern")) {
                is.add(eList.get(i - 1));
            }
        }
        System.out.println("Interns:");
        is.forEach(e -> System.out.println("\t" + e.toString()));
    }

    // create pending
    public void createPending() {
        for (int i = 1; i <= eList.size(); ++i) {               // for loop
            Employee e = eList.get(i - 1);                      // employee
            if (e instanceof HourlyEmployee) {                 // is hourly
                HourlyEmployee he = (HourlyEmployee) e;
                System.out.println("Paying " + e.getName() + " " + he.getRate()
                        + "$ per hour for " + he.getAmount() + " hours. Paying a total of " + he.getRate() * he.getAmount());
            } else if (e instanceof SalariedEmployee) {        // is salaried
                SalariedEmployee se = (SalariedEmployee) e;
                System.out.println("Paying " + e.getName() + " a weekly salary of " + se.getWeeklySalary() + "$.");
            } else {                                                 /// error
                throw new RuntimeException("something happened");
            }
        }
    }




    // give raise

    public void salaryRaise(Employee e, float raise) {
        if (raise < 0) { // if raise < 0, error
            throw new RuntimeException("oh no");
        }

        if (e instanceof HourlyEmployee) {
            HourlyEmployee he = (HourlyEmployee) e;
            he.setRate(he.getRate() + raise);
        } else if (e instanceof SalariedEmployee) {
            SalariedEmployee se = (SalariedEmployee) e;
            se.setWeeklySalary(se.getWeeklySalary() + raise);
        } else {
            throw new RuntimeException("something happened");
        }
    }

    /**
     *
     * @param e employee
     * @param payout if payout then pay 5 days @ 8 hours a day
     * @param amount null or not used if not needed
     */


    public void takeHoliday(Employee e, boolean payout, Integer amount) {
        // TODO this could probably be split in two methods...
        if (payout) {
            if (amount != null) { // if payout and amount != null
                throw new RuntimeException("bad input");
            }
        } else {
            if (amount == null) { // if not payout and null
                throw new RuntimeException("bad input");
            }
        }

        if (!payout && e.getVacation_days() < amount) { // cannot
            throw new RuntimeException("error");
        }
        if (e instanceof HourlyEmployee) {
            HourlyEmployee he = (HourlyEmployee) e;
            if (payout) {
                p.add(new Paycheck(e.getName(), 5 * 8 * ((HourlyEmployee)e).getRate())); // pay 5 days
                e.setVacation_days(e.getVacation_days() - 5);
            } else {
                e.setVacation_days(e.getVacation_days() - amount);
            }
        } else if (e instanceof SalariedEmployee) {
            SalariedEmployee se = (SalariedEmployee) e;

            if (payout) {
                p.add(new Paycheck(e.getName(), ((SalariedEmployee)e).getWeeklySalary())); // pay a week
                e.setVacation_days(e.getVacation_days() - 5);
            } else {
                e.setVacation_days(e.getVacation_days() - amount);
            }
        } else {
            throw new RuntimeException("something happened");
        }
    }





    public void getTotalmoney(Float t_float) {
        t_float = 0.f;
        for (int o = 0; o < this.p.size(); o = o + 1) {
            Paycheck p = this.p.get(o);
            t_float += p.getAmount();
        }
    }


    public void avgPayCehck(Float t_float, Float out_float) {
        if (this.p.size() == 0) {
            out_float = -1f;
        }
        t_float = 0.f;
        for (int o = 0; o < this.p.size(); o = o + 1) {
            Paycheck p = this.p.get(o);
            t_float += p.getAmount();
        }
        out_float = t_float / this.p.size();
    }



}
