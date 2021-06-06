package com.muskan.pricingservice.interfaces.implementations;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.muskan.pricingservice.constants.Constants.PRICE_ROUNDING_UPTO;
import static org.junit.jupiter.api.Assertions.*;

class SubscriptionBasedPricingStrategyTest {

    SubscriptionBasedPricingStrategy subscriptionBasedPricingStrategy = new SubscriptionBasedPricingStrategy();
    BigDecimal fee = BigDecimal.valueOf(100);
    @Test
    void getAmount() {

        BigDecimal amount = subscriptionBasedPricingStrategy.getAmount(fee);

        assertEquals(fee.divide(BigDecimal.valueOf(12),PRICE_ROUNDING_UPTO, RoundingMode.HALF_UP),amount,"");
    }

    @Test
    void getAmountForNMonths() {

        BigDecimal amount = subscriptionBasedPricingStrategy.getAmountForNMonths(fee,4);

        assertEquals(fee.divide(BigDecimal.valueOf(12),PRICE_ROUNDING_UPTO, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(4)),amount,"");

    }
}