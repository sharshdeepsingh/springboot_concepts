package org.sharshdeep.payment;

public class UPIPaymentService implements PaymentService{
    @Override
    public void pay() {
        System.out.println("Paid using UPI");
    }
}
