package com.muskan.pricingservice.interfaces.implementations;

import com.muskan.pricingservice.interfaces.PricingStrategy;

import java.math.BigDecimal;

public class SubscriptionBasedStrategy implements PricingStrategy {
    @Override
    public BigDecimal getAmount(BigDecimal courseFee) {
        return courseFee.divide(BigDecimal.valueOf(12));
    }
}
