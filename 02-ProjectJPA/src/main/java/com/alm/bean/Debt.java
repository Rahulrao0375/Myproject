package com.alm.bean;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "DEBT")
public class Debt extends Liability {

    private String lender;

    public Debt() {}

    public Debt(BigDecimal principalAmount, double interestRate, LocalDate maturityDate, String currency, String type, String lender) {
        super(principalAmount, interestRate, maturityDate, currency, type);
        this.lender = lender;
    }

    public String getLender() {
        return lender;
    }

    public void setLender(String lender) {
        this.lender = lender;
    }
}
