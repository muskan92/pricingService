package com.muskan.pricingservice.requstsandresponses;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Data
public class CoursePriceDetails {

    private BigDecimal basePrice;
    private BigDecimal taxes;
    private String currency;//enum
    private String priceStrategyType;
    private BigDecimal netPrice;

}
