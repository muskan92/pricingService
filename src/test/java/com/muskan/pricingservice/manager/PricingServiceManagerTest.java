package com.muskan.pricingservice.manager;

import com.muskan.pricingservice.constants.CountryCode;
import com.muskan.pricingservice.requstsandresponses.CoursePriceDetailsResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PricingServiceManagerTest {

    PricingServiceManager pricingServiceManager = new PricingServiceManager();

    @Test
    void calculateAndUpdateNetPricetest(){
        CoursePriceDetailsResponse result = pricingServiceManager.calculateAndUpdateNetPrice(
                new CoursePriceDetailsResponse("CS1", BigDecimal.valueOf(100),"INR"));

        assertEquals(BigDecimal.valueOf(100),result.getNetPrice(),"Net value is not correct");

    }

    @Test
    void setPriceDetailsBasedOnCountryTest(){
        CoursePriceDetailsResponse coursePriceDetailsResponse = new CoursePriceDetailsResponse("CS1", BigDecimal.valueOf(100),"INR");
        coursePriceDetailsResponse =    pricingServiceManager.setPriceDetailsBasedOnCountry(coursePriceDetailsResponse, CountryCode.USA);

        assertEquals(BigDecimal.valueOf(50),coursePriceDetailsResponse.getNetPrice(),"Net value is not correct");

    }

}