package com.muskan.pricingservice.constants;

import java.math.BigDecimal;

public enum CountryCode {
    IN ("India","INR",BigDecimal.valueOf(1)),
    USA ("United State Of Ameraica","USD",BigDecimal.valueOf(70.0)),
    CH ("China","YUAN",BigDecimal.valueOf(12.0));

    String countryName;
    String currency;
    BigDecimal conversionRateBaseINR;

    CountryCode(String countryName, String currencySymbol, BigDecimal conversionRateBaseINR) {
        this.countryName = countryName;
        this.currency = currencySymbol;
        this.conversionRateBaseINR = conversionRateBaseINR;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getConversionRateBaseINR() {
        return conversionRateBaseINR;
    }

    public void setConversionRateBaseINR(BigDecimal conversionRateBaseINR) {
        this.conversionRateBaseINR = conversionRateBaseINR;
    }
}
