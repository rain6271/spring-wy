package com.wy.spring.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author WangYu
 * @date 2023/12/2 19:41
 */
@Component
public class WyFactoryBean implements FactoryBean<UserService> {

    @Override
    public UserService getObject() throws Exception {
        return new UserService();
    }

    @Override
    public Class<?> getObjectType() {
        return UserService.class;
    }
}
