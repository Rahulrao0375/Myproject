package com.alm.bean;



import java.math.BigDecimal;
import java.time.LocalDate;

public class Debt extends Liability {
    private String lender;

    public Debt() {}

    public Debt(int id, BigDecimal principalAmount, double interestRate, LocalDate maturityDate, String currency, String type, String lender) {
        super(id, principalAmount, interestRate, maturityDate, currency, type);
        this.lender = lender;
    }

    public String getLender() {
        return lender;
    }

    public void setLender(String lender) {
        this.lender = lender;
    }
}

