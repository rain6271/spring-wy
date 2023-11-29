package com.wy.spring.service;

import com.wy.spring.bean.Autowired;
import com.wy.spring.bean.BeanNameAware;
import com.wy.spring.bean.Component;
import com.wy.spring.bean.Transactional;

/**
 * TODO
 *
 * @author WangYu
 * @date 2023/11/29 10:04
 */
@Component
public class UserService implements BeanNameAware, U {
    private String beanName;

    @Autowired
    private OrderService orderService;

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    public String getBeanName() {
        return beanName;
    }

    @Transactional
    public void testTransaction() {
        System.out.println("事务代理方法...");
    }

}
