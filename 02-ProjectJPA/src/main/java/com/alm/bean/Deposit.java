package com.alm.bean;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "DEPOSIT")
public class Deposit extends Liability {

    private String depositorName;

    public Deposit() {}

    public Deposit(BigDecimal principalAmount, double interestRate, LocalDate maturityDate, String currency, String type, String depositorName) {
        super(principalAmount, interestRate, maturityDate, currency, type);
        this.depositorName = depositorName;
    }

    public String getDepositorName() {
        return depositorName;
    }

    public void setDepositorName(String depositorName) {
        this.depositorName = depositorName;
    }
}