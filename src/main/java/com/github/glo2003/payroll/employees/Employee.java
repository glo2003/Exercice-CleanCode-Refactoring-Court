package com.github.glo2003.payroll.employees;


import com.github.glo2003.payroll.Role;

public abstract class Employee {
    private final String name;
    private final Role role;

    public Employee(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    abstract public float getPayForTwoWeeks();

    abstract public void giveRaise(float raise);

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
