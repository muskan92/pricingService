package com.muskan.pricingservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoursePriceDetailsEntity {

    private String courseId;
    private BigDecimal basePrice;
    private String currency;


}
