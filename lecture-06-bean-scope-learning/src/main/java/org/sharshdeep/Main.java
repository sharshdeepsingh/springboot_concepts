package org.sharshdeep;

import org.sharshdeep.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService orderService= context.getBean(OrderService.class);

        orderService.orderPlaced();

        OrderService orderService2= context.getBean(OrderService.class);
        orderService2.orderPlaced();

        System.out.println(orderService2==orderService);
    }
}