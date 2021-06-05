package com.muskan.pricingservice.interfaces.implementations;

import com.muskan.pricingservice.interfaces.PricingStrategy;

import java.math.BigDecimal;

public class AvailableForFreeStrategy implements PricingStrategy {
    @Override
    public BigDecimal getAmount(BigDecimal courseFee) {
        return BigDecimal.valueOf(0);
    }
}
