package com.alm.bean;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "BOND")
public class Bond extends Asset {

    private String issuer;

    public Bond() {}

    public Bond(BigDecimal principalAmount, double interestRate, LocalDate maturityDate, String currency, String type, String issuer) {
        super(principalAmount, interestRate, maturityDate, currency, type);
        this.issuer = issuer;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }
}