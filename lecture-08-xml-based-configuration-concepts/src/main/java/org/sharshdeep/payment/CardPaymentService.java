package org.sharshdeep.payment;

public class CardPaymentService implements PaymentService{
    @Override
    public void pay() {
        System.out.println("Paid using Card");
    }
}
