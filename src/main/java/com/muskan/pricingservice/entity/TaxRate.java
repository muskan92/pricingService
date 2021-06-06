package com.muskan.pricingservice.entity;

import lombok.Data;
import org.springframework.lang.NonNull;

import javax.persistence.*;

/**
 * TODO @Muskan
 */

@Data
public class TaxRate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    @NonNull
    private String countryCode;

    @Column
    private String taxType;

    @Column
    @NonNull
    private double rateInPercentage;

    @Column
    private boolean isActive;

}
