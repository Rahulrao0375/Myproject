package com.alm.bean;


import java.math.BigDecimal;
import java.time.LocalDate;

public class Bond extends Asset {
    private String issuer;

    public Bond() {}

    public Bond(int id, BigDecimal principalAmount, double interestRate, LocalDate maturityDate, String currency, String type, String issuer) {
        super(id, principalAmount, interestRate, maturityDate, currency, type);
        this.issuer = issuer;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }
}

