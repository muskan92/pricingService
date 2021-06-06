package com.muskan.pricingservice.manager;

import com.muskan.pricingservice.constants.CountryCode;
import com.muskan.pricingservice.constants.StrategyType;
import com.muskan.pricingservice.exception.CourseNotFoundException;
import com.muskan.pricingservice.interfaces.PricingStrategy;
import com.muskan.pricingservice.interfaces.implementations.StrategyFactory;
import com.muskan.pricingservice.interfaces.implementations.SubscriptionBasedPricingStrategy;
import com.muskan.pricingservice.mapper.CourseDetailsEntityToResponseMapper;
import com.muskan.pricingservice.repository.PricingServiceRepository;
import com.muskan.pricingservice.requstsandresponses.CoursePriceDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.muskan.pricingservice.constants.Constants.*;

@Service
public class PricingServiceManager {

    @Autowired
    PricingServiceRepository pricingServiceRepository;

    @Autowired
    CourseDetailsEntityToResponseMapper courseDetailsEntityToResponseMapper;

    @Autowired
    StrategyFactory strategyFactory;

    public CoursePriceDetailsResponse getCoursePriceDetails(String courseId, CountryCode countryCode, StrategyType strategyType, int subscriptionMonths) {

        CoursePriceDetailsResponse coursePriceDetailsResponse = courseDetailsEntityToResponseMapper
                .convert(pricingServiceRepository.getCourseDetailsById(courseId));

        if (coursePriceDetailsResponse == null)
            throw new CourseNotFoundException("Course Not found with courseId :" + courseId);


        coursePriceDetailsResponse = setPriceDetailsBasedOnCountry(coursePriceDetailsResponse, countryCode);
        coursePriceDetailsResponse.setPriceStrategyType(strategyType);
        coursePriceDetailsResponse.setAmountToPayAsPerStrategy(
                getAmountByStrategy(strategyType, subscriptionMonths, coursePriceDetailsResponse.getNetPrice()));

        return coursePriceDetailsResponse;

    }

    public CoursePriceDetailsResponse setPriceDetailsBasedOnCountry(CoursePriceDetailsResponse coursePriceDetailsResponse, CountryCode countryCode) {

        if (countryCode == CountryCode.IN) {
            return calculateAndUpdateNetPrice(coursePriceDetailsResponse);
        }
        coursePriceDetailsResponse.setCurrency(countryCode.getCurrency());

        coursePriceDetailsResponse.setCurrencyConversionCharge(FLAT_CURRENCY_CONVERSION_CHARGE_IN_RUPEES.divide(countryCode.getConversionRateBaseINR()));

        coursePriceDetailsResponse.setBasePrice(coursePriceDetailsResponse.getBasePrice().divide(countryCode.getConversionRateBaseINR(), PRICE_ROUNDING_UPTO, PRICE_ROUNDING_MODE));

        coursePriceDetailsResponse.setTaxesInPercent(coursePriceDetailsResponse.getTaxesInPercent().divide(countryCode.getConversionRateBaseINR(), PRICE_ROUNDING_UPTO, PRICE_ROUNDING_MODE));

        return calculateAndUpdateNetPrice(coursePriceDetailsResponse);

    }

    public CoursePriceDetailsResponse calculateAndUpdateNetPrice(CoursePriceDetailsResponse coursePriceDetailsResponse) {

        BigDecimal tax = coursePriceDetailsResponse.getBasePrice()
                .divide(BigDecimal.valueOf(100),PRICE_ROUNDING_UPTO,PRICE_ROUNDING_MODE)
                .multiply(coursePriceDetailsResponse.getTaxesInPercent());

        coursePriceDetailsResponse.setTaxAmount(tax);

        coursePriceDetailsResponse.setNetPrice(coursePriceDetailsResponse.getBasePrice()
                    .add(tax)
                    .add(coursePriceDetailsResponse.getCurrencyConversionCharge())); //For INR, its 0 byDefault

        return coursePriceDetailsResponse;

    }

    public BigDecimal getAmountByStrategy(StrategyType strategyType, int subscriptionMonths, BigDecimal amount){
        PricingStrategy pricingStrategy = strategyFactory.getStrategy(strategyType);

        if(subscriptionMonths > 1){
            SubscriptionBasedPricingStrategy SubscriptionBasedPricingStrategy = (SubscriptionBasedPricingStrategy) pricingStrategy;
            return SubscriptionBasedPricingStrategy.getAmountForNMonths(amount, subscriptionMonths);
        }

        return pricingStrategy.getAmount(amount);
    }

}

//