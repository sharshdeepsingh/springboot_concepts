package org.sharshdeep;

import org.sharshdeep.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args){

//        ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
        ConfigurableApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);

//        OrderService order= context.getBean(OrderService.class);
//
//order.placeOrder();

        CartService cartService= context.getBean(CartService.class);
        cartService.addToCart(1);

        context.close();
    }
}