package com.alm.bean;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Liability {
    private int id;
    private BigDecimal principalAmount;
    private double interestRate;
    private LocalDate maturityDate;
    private String currency;
    private String type; // fixed or variable

    public Liability() {
    }

    public Liability(int id, BigDecimal principalAmount, double interestRate, LocalDate maturityDate, String currency, String type) {
        this.id = id;
        this.principalAmount = principalAmount;
        this.interestRate = interestRate;
        this.maturityDate = maturityDate;
        this.currency = currency;
        this.type = type;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(BigDecimal principalAmount) {
        this.principalAmount = principalAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(LocalDate maturityDate) {
        this.maturityDate = maturityDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

