package com.alm.bean;


import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Liability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    private BigDecimal principalAmount;
    private double interestRate;
    private LocalDate maturityDate;
    private String currency;
    private String type;

    public Liability() {}

    public Liability(BigDecimal principalAmount, double interestRate, LocalDate maturityDate, String currency, String type) {
        this.principalAmount = principalAmount;
        this.interestRate = interestRate;
        this.maturityDate = maturityDate;
        this.currency = currency;
        this.type = type;
    }

    public Integer getId() {
        return id;
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
