package com.wy.spring.bean;

/**
 * TODO
 *
 * @author WangYu
 * @date 2023/11/29 11:12
 */
public interface BeanFactory {

    Object getBean(String beanName);

    Object getBean(Class<?> type);
}
