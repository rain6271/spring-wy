package com.wy.spring.test;

import com.wy.spring.AppConfig;
import com.wy.spring.bean.WyApplicationContext;
import com.wy.spring.service.UserService;

/**
 * TODO
 *
 * @author WangYu
 * @date 2023/11/29 9:58
 */
public class ApplicationTest {

    public static void main(String[] args) {
        WyApplicationContext context = new WyApplicationContext(AppConfig.class);

        UserService u = (UserService)context.getBean("userService");
        System.out.println(u);
        u.testTransaction();

    }

}
