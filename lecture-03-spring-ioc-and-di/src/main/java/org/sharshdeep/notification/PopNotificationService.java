package org.sharshdeep.notification;

public class PopNotificationService implements NotificationService {

    @Override
    public void sendNotification(){
        System.out.println("Popup Notification sent");
    }
}
