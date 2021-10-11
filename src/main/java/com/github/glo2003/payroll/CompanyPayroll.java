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




    public List<Paycheck> getPendings() {
        return this.p;
    }

}
