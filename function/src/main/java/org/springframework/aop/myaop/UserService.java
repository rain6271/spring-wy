package org.springframework.aop.myaop;

public class UserService {

    public Object insert() {
        System.out.println("插入成功");
        return null;
    }
}
