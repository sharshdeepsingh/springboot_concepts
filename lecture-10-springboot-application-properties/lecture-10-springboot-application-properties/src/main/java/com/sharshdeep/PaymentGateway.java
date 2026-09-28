package com.sharshdeep;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentGateway {

    // Use of the @Value annotation -> get the values from the env file application.pproperties , application.yaml file
//    @Value("${payment-property-type : PhonePe}")
//    private String type;
//
//    @Value("${payment-property-retry-count : 1}")
//    private int retryCount;


//    public PaymentGateway(@Value("${payment-property-type}") String type,
//                          @Value("${payment-property-retry-count}") int retryCount){
//        this.type=type;
//        this.retryCount=retryCount;
//    }

    private PaymentProperties paymentProperties;

    public PaymentGateway (PaymentProperties paymentProperties){
    this.paymentProperties=paymentProperties;
}

    public PaymentProperties getPaymentProperties() {
        return paymentProperties;
    }
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public int getRetryCount() {
//        return retryCount;
//    }
//
//    public void setRetryCount(int retryCount) {
//        this.retryCount = retryCount;
//    }


    public String getType() {
        return paymentProperties.getType();
    }
    public int getRetryCount() {
        return paymentProperties.getRetryCount();
    }
    public boolean isEnabled() {
        return paymentProperties.isEnabled();
    }
    public int getTimeout() {
        return paymentProperties.getTimeout();
    }

    public void print(){
        System.out.println(paymentProperties.getRetryCount());
        System.out.println(paymentProperties.getTimeout());
        System.out.println(paymentProperties.getType());
        System.out.println(paymentProperties.isEnabled());
    }

}
