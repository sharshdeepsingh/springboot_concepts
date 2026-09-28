package org.sharshdeep;

import org.springframework.stereotype.Component;

@Component
public class PaymentService {
    public void pay() {
        System.out.println("Payment has been completed");
    }
}
