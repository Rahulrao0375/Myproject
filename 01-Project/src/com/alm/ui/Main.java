package com.alm.ui;


import com.alm.bean.*;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // === 1. Create Asset and Liability Objects ===
        Loan loan1 = new Loan(
            1,
            new BigDecimal("1000000"),
            7.5,
            LocalDate.of(2029, 12, 31),
            "INR",
            "fixed",
            "Rahul Kumar"
        );

        Deposit deposit1 = new Deposit(
            101,
            new BigDecimal("500000"),
            5.0,
            LocalDate.of(2027, 6, 30),
            "INR",
            "fixed",
            "Shreya Sharma"
        );

        // === 2. Store in Lists (future: persist via EclipseLink JPA) ===
        List<Asset> assets = new ArrayList<>();
        assets.add(loan1);

        List<Liability> liabilities = new ArrayList<>();
        liabilities.add(deposit1);

        // === 3. Perform Risk Calculations ===
        System.out.println("=== Risk Metrics ===");
        double loanDuration = RiskCalculator.calculateDuration(loan1);
        double depositDuration = RiskCalculator.calculateDuration(deposit1);
        BigDecimal nii = RiskCalculator.calculateNII(loan1, deposit1);

        System.out.println("Loan Duration: " + loanDuration + " years");
        System.out.println("Deposit Duration: " + depositDuration + " years");
        System.out.println("Net Interest Income (NII): ₹" + nii);

        // === 4. Run Scenario Analysis ===
        System.out.println("\n=== Scenario Analysis ===");
        ScenarioAnalyzer.runScenario("Rate Hike (+1%)", loan1, deposit1, 1.0);
        ScenarioAnalyzer.runScenario("Rate Cut (-0.5%)", loan1, deposit1, -0.5);

        // === 5. Liquidity Ratio Calculation (Assume short-term values) ===
        BigDecimal shortTermAssets = new BigDecimal("300000");
        BigDecimal shortTermLiabilities = new BigDecimal("200000");
        double liquidityRatio = RiskCalculator.calculateLiquidityRatio(shortTermAssets, shortTermLiabilities);
        System.out.println("\nLiquidity Ratio: " + liquidityRatio);
    }
}

