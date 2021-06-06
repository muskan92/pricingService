package com.muskan.pricingservice.interfaces.implementations;

import com.muskan.pricingservice.interfaces.PricingStrategy;

import java.math.BigDecimal;

import static com.muskan.pricingservice.constants.Constants.PRICE_ROUNDING_MODE;
import static com.muskan.pricingservice.constants.Constants.PRICE_ROUNDING_UPTO;

public class SubscriptionBasedPricingStrategy implements PricingStrategy
{
    /**
     *
     * @param courseFee
     * @return  amount for 1 month subscription
     */

    @Override
    public BigDecimal getAmount(BigDecimal courseFee) {

        return courseFee.divide(BigDecimal.valueOf(12),PRICE_ROUNDING_UPTO, PRICE_ROUNDING_MODE);
    }

    /**
     *
     * @param courseFee
     * @param month
     * @return amount for N months subscription
     */
    public BigDecimal getAmountForNMonths(BigDecimal courseFee, int month) {
        return courseFee.divide(BigDecimal.valueOf(12),PRICE_ROUNDING_UPTO, PRICE_ROUNDING_MODE).multiply(BigDecimal.valueOf(month));
    }
}
