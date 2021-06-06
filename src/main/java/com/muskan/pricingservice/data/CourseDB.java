package com.muskan.pricingservice.data;

import com.muskan.pricingservice.entity.CoursePriceDetailsEntity;
import com.muskan.pricingservice.requstsandresponses.CoursePriceDetailsResponse;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
public class CourseDB {

    Map<String, CoursePriceDetailsEntity> courseIdPriceDetailsMap = new HashMap<>();

    public CourseDB() {

        courseIdPriceDetailsMap.put("CS1", new CoursePriceDetailsEntity("CS1", BigDecimal.valueOf(100),
                "INR"));

        courseIdPriceDetailsMap.put("CS2", new CoursePriceDetailsEntity("CS2", BigDecimal.valueOf(200)
                , "INR"));


    }

    public CoursePriceDetailsEntity getCoursePriceDetails(String courseId) {
        return courseIdPriceDetailsMap.get(courseId);
    }
}
