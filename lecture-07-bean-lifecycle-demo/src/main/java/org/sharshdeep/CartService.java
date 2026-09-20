package org.sharshdeep;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

//@Component
//public class CartService implements InitializingBean {
public class CartService implements BeanNameAware, ApplicationContextAware  /*  ,DisposableBean  */ {
    Map<Integer,String> mp;

    public CartService(){
        mp=new HashMap<>();
        System.out.println("ChartService Constructor called");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean name is "+name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Appllication contex tname is : "+ applicationContext.getClass());
    }

    @PostConstruct
    public void setPostConstructValues(){
        System.out.println("Bean Is Ready");
   mp.put(1,"Harshdeep Singh Saini");
   mp.put(2,"Nida Waseem");
    }


//    @Override  used by the initializing bean interface method
//    public void afterPropertiesSet() throws Exception {
//        mp.put(1,"Harshdeep Singh Saini");
//        mp.put(2,"Nida Waseem");
//    }

    public void addToCart(Integer key){
        System.out.println("Added to Cart");
        System.out.println(returnValue(key));
    }

    public String returnValue(Integer key){
        return mp.get(key);
    }

//    @Override
//    public void destroy() throws Exception {
//        mp.clear();
//        System.out.println("Bean is getting destroyed");
//    }



//    // used by the init method of the initiliating callback phase of the bean lifecycle
//    public void start(){
//        System.out.println("Bean Is Ready");
//        mp.put(1,"Harshdeep Singh Saini");
//        mp.put(2,"Nida Waseem");
//    }

    //    // used by the destroy method of the destroy callback phase of the bean lifecycle
//    public void stop(){
//        System.out.println("Bean Is Destroyed");
//    }

}
