package org.springframework.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Run {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        MathService mathService = (MathService) context.getBean("mathService");
        mathService.division(1, 1);
        System.out.println(mathService);


    }


}
