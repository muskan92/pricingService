package com.muskan.pricingservice.requstsandresponses;

import com.muskan.pricingservice.constants.StrategyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoursePriceDetailsResponse {

    private String courseId;
    private BigDecimal basePrice;
    private BigDecimal taxesInPercent = BigDecimal.valueOf(.2);
    private String currency;
    private BigDecimal netPrice;
    //For INR, its 0 byDefault
    private BigDecimal taxAmount;
    private BigDecimal currencyConversionCharge = BigDecimal.valueOf(0);
    private StrategyType priceStrategyType = StrategyType.ONE_TIME_PAYMENT;
    private BigDecimal amountToPayAsPerStrategy;

    public CoursePriceDetailsResponse(String courseId, BigDecimal basePrice, String currency) {
        this.courseId = courseId;
        this.basePrice = basePrice;
        this.currency = currency;
    }
}
