package org.sharshdeep.config;

import org.sharshdeep.CartService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.sharshdeep")
public class AppConfig {

    // init Method of the spring bean lifecycle
//    @Bean(initMethod = "start")
    @Bean
    // @Bean(destoryMethod="stop")
    public CartService createCartServiceBean(){
        return new CartService();
    }
}
