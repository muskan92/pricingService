package com.muskan.pricingservice.interfaces;

public interface EntityResponseMapper<E,R> {

    R convert(E entity);
}
