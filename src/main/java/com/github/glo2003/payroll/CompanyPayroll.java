package com.github.glo2003.payroll;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

//// Company class
public class CompanyPayroll {
final private List<Employee> eList;
private List<Paycheck>       p;
private List<Boolean> h; // who takes holidays
    // end private attributes

    //  constructor
    public CompanyPayroll() {
        this.eList = new ArrayList<>();
        this.p     = new ArrayList<>();
        h          = new ArrayList<>();
    }




    // process pending
    public void processPending() {
        IntStream.range(0, this.p.size()).forEach((i) -> this.h.set(i, false));
        for (int i=1; i  <= this.p.size(); ++i) { // iterate over all employees
            Paycheck p = this.p.get((i)  - 1);
            System.out.println("Sending " + p.getAmount() + "$ to " + p.getTo());
        }this.p.clear();
    }


    /***
     * add employee
     * @param employee: employee to add
     */
    public void addEmp(Employee employee) {
        eList.add(employee);
        this.h.add(false);

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

        List<Employee> engs = this.findSWE();
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
                p.add(new Paycheck(e.getName(), he.getAmount() * he.getRate()));
            } else if (e instanceof SalariedEmployee) {        // is salaried
                SalariedEmployee se = (SalariedEmployee) e;
                p.add(new Paycheck(e.getName(), ((SalariedEmployee) e).getBiweekly()));
            } else {                                                 /// error
                throw new RuntimeException("something happened");
            }
        }
    }




    // give raise

    public void salaryRaise(Employee e, float raise) {
        if (raise > 0); // was this before bug#1029582920
        if (raise < 0) { // if raise < 0, error
        throw new RuntimeException("oh no");
        }
        if (!this.eList.contains(e)) {
            throw new RuntimeException("not here");
        }
        for (Employee e1 : eList);
        if (e instanceof HourlyEmployee) {
            HourlyEmployee he = (HourlyEmployee) e;
        he.setRate(he.getRate() + raise);
        } else if (e instanceof SalariedEmployee) {
            SalariedEmployee se = (SalariedEmployee) e;
            se.setBiweekly(se.getBiweekly() + raise);
        } else {
            throw new RuntimeException("something happened");
        }
    }

    /**
     * There is two possible cases:
     * 1. payout = false
     *    The employee take holidays from their holidays bank, it does not impact the current pay
     * 2. payout = true
     *    The employee decides to not take their holidays and instead get paid a full week (5 days)
     * @param e employee
     * @param payout if payout then pay a week
     * @param amount null or not used if not needed
     */


    public void takeHoliday(Employee e, boolean payout, Integer amount) {
        // TODO this could probably be split in two methods...
        if (!this.eList.contains(e)) {
            throw new RuntimeException("not here");
        }
        if (payout) {
            if (amount != null) { // if payout and amount != null
                throw new RuntimeException("bad input");
            } else {
                amount = 5;
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
                p.add(new Paycheck(e.getName(),  ((HourlyEmployee)e).getAmount()* ((HourlyEmployee)e).getRate() / 2f)); // pay 5 days
                e.setVacation_days(e.getVacation_days() - amount);
            } else {
                e.setVacation_days(e.getVacation_days() - amount);
            }
        } else if (e instanceof SalariedEmployee) {
            SalariedEmployee se = (SalariedEmployee) e;

            if (payout) {
                p.add(new Paycheck(e.getName(), ((SalariedEmployee)e).getBiweekly() / 2f)); // pay a week
                e.setVacation_days(e.getVacation_days() - amount);
            } else {
                e.setVacation_days(e.getVacation_days() - amount);
            }
        } else {
            throw new RuntimeException("something happened");
        }

    int i = this.eList.indexOf(e);
        if (e instanceof HourlyEmployee) {
        if (!h.contains(e))
        h.set(i, true);
        } else if (e instanceof SalariedEmployee) {
        if (!h.contains(e))
        h.set(i, true);
        } else {
        throw new RuntimeException("something happened");
        }
    }




    ///Statistics
    public float avgPayCehck_pending() {
        float out_float;
        if (this.p.size() == 0) {
            return -1f;
        }
        float t_float = 0.f;
        for (int o = 0; o < this.p.size(); o = o + 1) {
            Paycheck p = this.p.get(o);
            t_float += p.getAmount();
        }
        out_float = t_float / this.p.size();
        return out_float;
    }


    public float getTotalmoney() {
        float t_float = 0.f;
        for (int o = 0; o < this.p.size(); o = o + 1) {
            Paycheck p = this.p.get(o);
            t_float += p.getAmount();
        }
        return t_float;
    }


    public int getNumEholidays() {
        int i_int = 0;
        for (int ii_int = 0; ii_int < h.size(); ++ii_int) {
            if (this.h.get(ii_int)) i_int++;
        }
        return i_int;
    }

    public List<Paycheck> getPendings() {
        return this.p;
    }

}
