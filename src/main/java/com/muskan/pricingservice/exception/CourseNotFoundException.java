package com.muskan.pricingservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Course not found")
public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(String message) {

        super(message);
    }
}
