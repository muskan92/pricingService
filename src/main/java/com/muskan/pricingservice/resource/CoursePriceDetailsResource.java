package com.muskan.pricingservice.resource;

import com.muskan.pricingservice.requstsandresponses.CoursePriceDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/pricingService/v1.1")
public class CoursePriceDetailsResource {


    @RequestMapping(path = "/coursePriceDetails/{courseId}", method = RequestMethod.GET)
    public ResponseEntity<?> getCoursePriceDetails(@PathVariable int courseId){
        CoursePriceDetails coursePriceDetails = new CoursePriceDetails();

        return new ResponseEntity<>(coursePriceDetails, HttpStatus.OK);
    }

    @RequestMapping(path = "/batch/coursePriceDetails/{courseId}", method = RequestMethod.POST)
    public ResponseEntity<?> getCourseBatchPriceDetails(@RequestBody List<Integer> courseIds){

        List<CoursePriceDetails> priceDetails = new ArrayList<>();

        return new ResponseEntity<>(priceDetails, HttpStatus.OK);
    }
}
