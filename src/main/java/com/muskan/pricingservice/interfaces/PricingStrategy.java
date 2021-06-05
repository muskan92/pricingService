package com.muskan.pricingservice.interfaces;

import java.math.BigDecimal;

public interface PricingStrategy {
    BigDecimal getAmount(BigDecimal courseFee);
}
