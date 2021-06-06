package com.muskan.pricingservice.controller;

import com.muskan.pricingservice.constants.CountryCode;
import com.muskan.pricingservice.constants.StrategyType;
import com.muskan.pricingservice.manager.PricingServiceManager;
import com.muskan.pricingservice.requstsandresponses.CoursePriceDetailsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/pricingService/v1.1")
public class CoursePriceDetailsResource {

    @Autowired
    PricingServiceManager pricingServiceManager;


    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(path = "/coursePriceDetails/{courseId}", method = RequestMethod.GET)
    public ResponseEntity<?> getCoursePriceDetails(@PathVariable String courseId,
                                                   @RequestParam(defaultValue = "IN") CountryCode countryCode,
                                                   @RequestParam(defaultValue = "ONE_TIME_PAYMENT") StrategyType strategyType,
                                                   @RequestParam(defaultValue = "1") int subscriptionMonths) {

        logger.info("Getting price Details for {} and countryCode {} ", courseId, countryCode);

        CoursePriceDetailsResponse coursePriceDetailsResponse = pricingServiceManager.getCoursePriceDetails(courseId, countryCode, strategyType, subscriptionMonths);

        return new ResponseEntity<>(coursePriceDetailsResponse, HttpStatus.OK);
    }

    @RequestMapping(path = "/batch/coursePriceDetails", method = RequestMethod.POST)
    public ResponseEntity<?> getCourseBatchPriceDetails(@RequestBody List<String> courseIds,
                                                        @RequestParam(defaultValue = "IN") CountryCode countryCode,
                                                        @RequestParam(defaultValue = "ONE_TIME_PAYMENT") StrategyType strategyType,
                                                        @RequestParam(defaultValue = "1") int subscriptionMonths) {


        Map<String,CoursePriceDetailsResponse> priceDetails = courseIds.stream().map(courseId ->
            pricingServiceManager.getCoursePriceDetails(courseId, countryCode, strategyType, subscriptionMonths)
        ).collect(Collectors.toMap(CoursePriceDetailsResponse::getCourseId, Function.identity()));

        return new ResponseEntity<>(priceDetails, HttpStatus.OK);
    }
}
