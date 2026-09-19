package org.sharshdeep;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("singleton")
@Scope("singleton")
public class OrderService {

    public OrderService(){
        System.out.println("Order Bean Created");
    }

    public void orderPlaced(){
        System.out.println("Order Placed");
    }
}
