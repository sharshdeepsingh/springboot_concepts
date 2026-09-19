package org.sharshdeep;

import org.sharshdeep.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
public class OrderService {

    PaymentService paymentService;
// Below is the example of Field Injection
// @Autowired
// private PaymentService paymentService;

    // Below is DI
    // Specifically Constructor DI
//    @Autowired
//    public OrderService(PaymentService paymentService){
//        this.paymentService=paymentService;
//    }


    // Below is setter DI how it will work is :
    // After the object of the orderService is created Spring will automatically
    // run the setter method to set the value , why automatically because of the @Autowired annotation

    @Autowired
    public void setPaymentService(@Qualifier("cp") PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder(){
        System.out.println("Order Placed");
        paymentService.pay();
    }
}
