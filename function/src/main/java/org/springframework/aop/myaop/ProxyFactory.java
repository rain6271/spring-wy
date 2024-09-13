package org.springframework.aop.myaop;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {
    private Object target;

    public UserService getProxy(Object target) {
        this.target = target;
        // CGLIB生成代理对象
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setClassLoader(target.getClass().getClassLoader());
        enhancer.setCallback(this);

        return (UserService) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("前置通知");
        Object invoke = null;
        try {
            invoke = methodProxy.invoke(target, objects);

        } catch (Exception e) {
            System.out.println("异常通知");
        } finally {
            System.out.println("后置通知");

        }

        return invoke;
    }
}
