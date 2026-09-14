package org.sharshdeep;

import org.sharshdeep.notification.EmailService;
import org.sharshdeep.notification.NotificationService;
import org.sharshdeep.notification.PopNotificationService;
import org.sharshdeep.notification.SmsService;

public class OrderService {

    NotificationService notificationService;


// Constructor Dependancy ijection
//    public OrderService(NotificationService notificationService){
//        this.notificationService=notificationService;
//    }

    public void placeOrder(){
        System.out.println("Order Placed");
        notificationService.sendNotification();
    }

    // seter dependency injection
    public void setNotificationService(NotificationService notificationService){
        this.notificationService=notificationService;
    }
}
