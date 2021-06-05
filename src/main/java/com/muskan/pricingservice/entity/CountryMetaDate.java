package com.muskan.pricingservice.entity;

import lombok.Data;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Data
@Entity
public class CountryMetaDate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int countryId;

    @Column
    @NonNull
    private String countryCode;

    @Column
    @NonNull
    private String countryName;
}
