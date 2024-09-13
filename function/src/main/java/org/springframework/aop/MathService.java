package org.springframework.aop;


import org.springframework.stereotype.Component;

@Component
public class MathService {

    public Integer division(int x, int y) {
        return x / y;
    }
}
