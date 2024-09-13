package org.springframework.aop.myaop;

import org.springframework.aop.AopConfig;
import org.springframework.aop.MathService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Run {

    public static void main(String[] args) {
        UserService userService = new UserService();
        UserService proxy = new ProxyFactory().getProxy(userService);
        proxy.insert();


    }


}
