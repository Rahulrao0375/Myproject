package com.alm.bean;





import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RiskCalculator {

    // Duration = (Maturity in years) * (Interest rate sensitivity factor)
    public static double calculateDuration(Asset asset) {
        long years = ChronoUnit.YEARS.between(LocalDate.now(), asset.getMaturityDate());
        return years * (asset.getType().equalsIgnoreCase("fixed") ? 0.8 : 1.2);
    }

    public static double calculateDuration(Liability liability) {
        long years = ChronoUnit.YEARS.between(LocalDate.now(), liability.getMaturityDate());
        return years * (liability.getType().equalsIgnoreCase("fixed") ? 0.8 : 1.2);
    }

    // Net Interest Income = total interest from assets - total interest from liabilities
    public static BigDecimal calculateNII(Asset asset, Liability liability) {
        BigDecimal assetIncome = asset.getPrincipalAmount()
            .multiply(BigDecimal.valueOf(asset.getInterestRate() / 100));
        BigDecimal liabilityCost = liability.getPrincipalAmount()
            .multiply(BigDecimal.valueOf(liability.getInterestRate() / 100));
        return assetIncome.subtract(liabilityCost);
    }

    // Liquidity ratio = (short term assets / short term liabilities)
    public static double calculateLiquidityRatio(BigDecimal shortTermAssets, BigDecimal shortTermLiabilities) {
        if (shortTermLiabilities.compareTo(BigDecimal.ZERO) == 0) return Double.POSITIVE_INFINITY;
        return shortTermAssets.divide(shortTermLiabilities, 2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
