package com.wy.spring.bean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author WangYu
 * @date 2023/11/29 14:06
 */
public class TransactionalInvocation implements InvocationHandler {

    private Object target;

    public TransactionalInvocation(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理方法执行前...........");
        method.invoke(target, args);
        System.out.println("代理方法执行后...........");
        return proxy;
    }
}
