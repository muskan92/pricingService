package com.muskan.pricingservice.interfaces.implementations;

import com.muskan.pricingservice.constants.StrategyType;
import com.muskan.pricingservice.interfaces.PricingStrategy;
import org.springframework.stereotype.Component;

@Component
public class StrategyFactory {

    public PricingStrategy getStrategy(StrategyType strategyType){
        if(strategyType == StrategyType.FREE)
            return new AvailableForFreeStrategy();
        else if(strategyType == StrategyType.ONE_TIME_PAYMENT)
            return new OneTimePaymentStrategy();
        else if(strategyType == StrategyType.SUBSCRIPTION_BASED)
            return new SubscriptionBasedPricingStrategy();
        else
            return new OneTimePaymentStrategy();
    }

}
