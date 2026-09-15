package org.sharshdeep.payment;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Qualifier("up")
//@Primary
@Component
public class UpiPayment implements PaymentService{
    public void pay(){
        System.out.println("Payment made via UPI");
    }
}
