package com.muskan.pricingservice.repository;

import com.muskan.pricingservice.data.CourseDB;
import com.muskan.pricingservice.entity.CoursePriceDetailsEntity;
import com.muskan.pricingservice.requstsandresponses.CoursePriceDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PricingServiceRepository {

    @Autowired
    private CourseDB courseDB;

    public CoursePriceDetailsEntity getCourseDetailsById(String courseId){
        return courseDB.getCoursePriceDetails(courseId);
    }

}
