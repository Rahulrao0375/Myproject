package com.alm.bean;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "LOAN")
public class Loan extends Asset {

    private String borrowerName;

    public Loan() {}

    public Loan(BigDecimal principalAmount, double interestRate, LocalDate maturityDate, String currency, String type, String borrowerName) {
        super(principalAmount, interestRate, maturityDate, currency, type);
        this.borrowerName = borrowerName;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }
}
