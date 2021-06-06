package com.muskan.pricingservice.constants;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Constants {
    public static final BigDecimal FLAT_CURRENCY_CONVERSION_CHARGE_IN_RUPEES = BigDecimal.valueOf(70);
    public static final int PRICE_ROUNDING_UPTO = 3;
    public static final RoundingMode PRICE_ROUNDING_MODE = RoundingMode.HALF_EVEN;
}
