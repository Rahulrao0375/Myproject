package com.alm.ui;

import com.alm.bean.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ALM_PU");
        EntityManager em = emf.createEntityManager();

        try {
           
            Loan loan1 = new Loan(
                    new BigDecimal("1000000"),
                    7.5,
                    LocalDate.of(2029, 12, 31),
                    "INR",
                    "fixed",
                    "Rahul Kumar"
            );

            Deposit deposit1 = new Deposit(
                    new BigDecimal("500000"),
                    5.0,
                    LocalDate.of(2027, 6, 30),
                    "INR",
                    "fixed",
                    "Shreya Sharma"
            );

            
            em.getTransaction().begin();
            em.persist(loan1);
            em.persist(deposit1);
            em.getTransaction().commit();

           
            System.out.println("=== Risk Metrics ===");
            double loanDuration = RiskCalculator.calculateDuration(loan1);
            double depositDuration = RiskCalculator.calculateDuration(deposit1);
            BigDecimal nii = RiskCalculator.calculateNII(loan1, deposit1);

            System.out.println("Loan Duration: " + loanDuration + " years");
            System.out.println("Deposit Duration: " + depositDuration + " years");
            System.out.println("Net Interest Income (NII): ₹" + nii);

           
            System.out.println("\n=== Scenario Analysis ===");
            ScenarioAnalyzer.runScenario("Rate Hike (+1%)", loan1, deposit1, 1.0);
            ScenarioAnalyzer.runScenario("Rate Cut (-0.5%)", loan1, deposit1, -0.5);

         
            BigDecimal shortTermAssets = new BigDecimal("300000");
            BigDecimal shortTermLiabilities = new BigDecimal("200000");
            double liquidityRatio = RiskCalculator.calculateLiquidityRatio(shortTermAssets, shortTermLiabilities);
            System.out.println("\nLiquidity Ratio: " + liquidityRatio);
        } finally {
            
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}

