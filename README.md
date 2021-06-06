# pricingService
Project for Pricing Service For an Online Course Portal

#Project SetUp
    Install and setUp Java
    Install and setUp Maven
    Run the following command on terminal
        mvn clean install -U
        mvn clean test
        mvn spring-boot:run
    Note: No DB setup required, its in memory
    Then hit the below APIs:


#cURL And Response

1:

curl --location --request GET 'http://localhost:8080/pricingService/v1.1/coursePriceDetails/CS1?countryCode=USA&strategyType=ONE_TIME_PAYMENT'


{
    "courseId": "CS1",
    "basePrice": 1.429,
    "taxesInPercent": 0.003,
    "currency": "USD",
    "netPrice": 2.429042,
    "taxAmount": 0.000042,
    "currencyConversionCharge": 1,
    "priceStrategyType": "ONE_TIME_PAYMENT",
    "amountToPayAsPerStrategy": 2.429042
}

2:

curl --location --request GET 'http://localhost:8080/pricingService/v1.1/coursePriceDetails/CS2?countryCode=USA&strategyType=FREE'


{
    "courseId": "CS2",
    "basePrice": 2.857,
    "taxesInPercent": 0.003,
    "currency": "USD",
    "netPrice": 3.857087,
    "taxAmount": 0.000087,
    "currencyConversionCharge": 1,
    "priceStrategyType": "FREE",
    "amountToPayAsPerStrategy": 0
}

3:

curl --location --request GET 'http://localhost:8080/pricingService/v1.1/coursePriceDetails/CS2?countryCode=USA&strategyType=SUBSCRIPTION_BASED&subscriptionMonths=4'

{
    "courseId": "CS2",
    "basePrice": 2.857,
    "taxesInPercent": 0.003,
    "currency": "USD",
    "netPrice": 3.857087,
    "taxAmount": 0.000087,
    "currencyConversionCharge": 1,
    "priceStrategyType": "SUBSCRIPTION_BASED",
    "amountToPayAsPerStrategy": 1.284
}

4:

curl --location --request GET 'http://localhost:8080/pricingService/v1.1/coursePriceDetails/CS2?countryCode=IN&strategyType=SUBSCRIPTION_BASED'

{
    "courseId": "CS2",
    "basePrice": 200,
    "taxesInPercent": 0.2,
    "currency": "INR",
    "netPrice": 200.4000,
    "taxAmount": 0.4000,
    "currencyConversionCharge": 0,
    "priceStrategyType": "SUBSCRIPTION_BASED",
    "amountToPayAsPerStrategy": 16.700
}

5:

curl --location --request POST 'http://localhost:8080/pricingService/v1.1/batch/coursePriceDetails?countryCode=USA&strategyType=ONE_TIME_PAYMENT' \
--header 'Content-Type: application/json' \
--data-raw '["CS1","CS2"]'


{
    "CS1": {
        "courseId": "CS1",
        "basePrice": 1.429,
        "taxesInPercent": 0.003,
        "currency": "USD",
        "netPrice": 2.429042,
        "taxAmount": 0.000042,
        "currencyConversionCharge": 1,
        "priceStrategyType": "ONE_TIME_PAYMENT",
        "amountToPayAsPerStrategy": 2.429042
    },
    "CS2": {
        "courseId": "CS2",
        "basePrice": 2.857,
        "taxesInPercent": 0.003,
        "currency": "USD",
        "netPrice": 3.857087,
        "taxAmount": 0.000087,
        "currencyConversionCharge": 1,
        "priceStrategyType": "ONE_TIME_PAYMENT",
        "amountToPayAsPerStrategy": 3.857087
    }
}


#Brief:
1: Conversion rate is hardcoded in enum as per country, same can be fetched from third party API at runtime.
2: Tax rate is flat for now, we can use TaxRate which will be configurable
