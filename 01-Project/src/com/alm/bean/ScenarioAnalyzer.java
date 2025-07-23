package com.alm.bean;





import java.math.BigDecimal;

public class ScenarioAnalyzer {

    public static BigDecimal simulateRateImpactOnAsset(Asset asset, double interestRateChange) {
        double newRate = asset.getInterestRate() + interestRateChange;
        return asset.getPrincipalAmount().multiply(BigDecimal.valueOf(newRate / 100));
    }

    public static BigDecimal simulateRateImpactOnLiability(Liability liability, double interestRateChange) {
        double newRate = liability.getInterestRate() + interestRateChange;
        return liability.getPrincipalAmount().multiply(BigDecimal.valueOf(newRate / 100));
    }

    public static void runScenario(String scenarioName, Asset asset, Liability liability, double rateChange) {
        System.out.println("Scenario: " + scenarioName);
        System.out.println("New Asset Interest Value: " + simulateRateImpactOnAsset(asset, rateChange));
        System.out.println("New Liability Interest Value: " + simulateRateImpactOnLiability(liability, rateChange));
    }
}

