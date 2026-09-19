package org.sharshdeep;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.sharshdeep")
public class AppConfig {

    @Bean
public User createUser(){
    return new User(28,"Harshdeep");
}

@Bean
    public CartService createCart(){
        return new CartService();
}

@Bean
    public OrderService createOrderService(){
        return new OrderService();
}
}
