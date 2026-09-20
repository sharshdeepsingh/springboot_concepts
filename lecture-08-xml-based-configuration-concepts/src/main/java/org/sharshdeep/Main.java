package org.sharshdeep;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");

        // get bean by type
//        OrderService order= context.getBean(OrderService.class);

//        // get bean by ID will not work if we have two beans of the same type
//        OrderService order= (OrderService) context.getBean("orderService");

        OrderService orderService= context.getBean("orderService", OrderService.class);
        orderService.placeOrder();
    }
}