package com.github.glo2003.payroll;

public class Paycheck {
    private final String to;
    private final float amount;

    public Paycheck(String to, float amount) {
        this.to = to;
        this.amount = amount;
    }

    public String getTo() {
        return to;
    }

    public float getAmount() {
        return amount;
    }
}
