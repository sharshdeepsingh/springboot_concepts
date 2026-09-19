package org.sharshdeep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService= context.getBean(OrderService.class);
        CartService cart= context.getBean(CartService.class);
        cart.addToCart();
  orderService.placeOrder();


//        OrderService orderService= new OrderService(new PaymentService());
//        orderService.placeOrder();

//        Student s1= new Student();

        // How the reflection works and what it stores?
//        Class<Student> c1=Student.class;
        // Class holds the metadata of the student class:
        //1. Name of the class
        //2. Constructors of the class
        //3. fields of the class
        //4. Method -> getAttendance,
////    }
//}

//class Student{
//    private String name;
//    private int age;
//
//    public Student(){
//
//    }
//
//    public void getAttendance(){
//
//    }
//
//    public void print(){
//
    }

}