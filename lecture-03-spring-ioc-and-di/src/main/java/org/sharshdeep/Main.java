package org.sharshdeep;

import org.sharshdeep.notification.EmailService;
import org.sharshdeep.notification.PopNotificationService;
import org.sharshdeep.notification.SmsService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Constructor DI
//        OrderService orderService= new OrderService(new EmailService());

        // Setter DI
        OrderService orderService=new OrderService();
        orderService.setNotificationService(new SmsService());
        orderService.placeOrder();
    }
}