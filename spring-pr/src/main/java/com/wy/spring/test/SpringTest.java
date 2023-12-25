package com.wy.spring.test;

import com.wy.spring.AppConfig;
import com.wy.spring.bean.UserService;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

/**
 * TODO
 *
 * @author WangYu
 * @date 2023/11/29 15:41
 */
public class SpringTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
//        beanDefinition.setBeanClass(UserService.class);
//        context.registerBeanDefinition("userService", beanDefinition);
//        context.refresh();
//        UserService userService = (UserService)context.getBean("userService");
//        System.out.println(userService);

//        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(context);
//        reader.register(UserService.class);
//        context.refresh();
//        UserService userService = (UserService)context.getBean("userService");
//        System.out.println(userService);

//        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(context);
//        xmlBeanDefinitionReader.loadBeanDefinitions("spring.xml");
//        context.refresh();
//        System.out.println(context.getBean("userService"));

//        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(context);
//        scanner.scan("com.wy.spring.bean");
//        context.refresh();
//        System.out.println(context.getBean("userService"));

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        beanDefinition.setBeanClass(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        System.out.println(beanFactory.getBean("userService"));
        context.refresh();
        Object userService = context.getBean("userService");
        System.out.println(userService);



    }
}
