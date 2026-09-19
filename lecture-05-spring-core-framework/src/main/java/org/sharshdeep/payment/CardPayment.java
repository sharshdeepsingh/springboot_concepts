package org.sharshdeep.payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Qualifier("cp")
@Component
public class CardPayment implements PaymentService{
    @Override
    public void pay(){
        System.out.println("Payment Made via Card");
    }
}
