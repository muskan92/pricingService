package com.muskan.pricingservice.interfaces.implementations;

import com.muskan.pricingservice.interfaces.PricingStrategy;

import java.math.BigDecimal;

public class SubscriptionBasedPricingStrategy implements PricingStrategy
{
    /**
     *
     * @param courseFee
     * @return  amount for 1 month subscription
     */

    @Override
    public BigDecimal getAmount(BigDecimal courseFee) {

        return courseFee.divide(BigDecimal.valueOf(12));
    }

    /**
     *
     * @param courseFee
     * @param month
     * @return amount for N months subscription
     */
    public BigDecimal getAmountForNMonths(BigDecimal courseFee, int month) {
        return courseFee.divide(BigDecimal.valueOf(12)).multiply(BigDecimal.valueOf(month));
    }
}
