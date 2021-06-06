package com.muskan.pricingservice.mapper;

import com.muskan.pricingservice.entity.CoursePriceDetailsEntity;
import com.muskan.pricingservice.interfaces.EntityResponseMapper;
import com.muskan.pricingservice.requstsandresponses.CoursePriceDetailsResponse;
import org.springframework.stereotype.Component;

@Component
public class CourseDetailsEntityToResponseMapper implements EntityResponseMapper<CoursePriceDetailsEntity, CoursePriceDetailsResponse> {


    @Override
    public CoursePriceDetailsResponse convert(CoursePriceDetailsEntity entity) {

        return new CoursePriceDetailsResponse(entity.getCourseId(),entity.getBasePrice(),entity.getCurrency());
    }
}
