package com.wy.spring.test;

import com.wy.spring.AppConfig;
import com.wy.spring.bean.A;
import com.wy.spring.bean.B;
import com.wy.spring.bean.User;
import com.wy.spring.entity.StringToUserPropertyEditor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.OrderComparator;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * TODO
 *
 * @author WangYu
 * @date 2023/11/29 15:41
 */
public class AppTest {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        String en_us = context.getMessage("weather.is.nice", null, new Locale("en_us"));
//        System.out.println(en_us);
//        Resource[] resources = context.getResources("classpath:com/wy/spring/bean/*.class");
//        for (Resource resource : resources) {
//            System.out.println(resource.getFilename());
//        }
//        Map<String, Object> systemEnvironment = context.getEnvironment().getSystemEnvironment();
//        System.out.println(systemEnvironment);
//
//        MutablePropertySources propertySources = context.getEnvironment().getPropertySources();
//        System.out.println(propertySources.get("profile"));
//
//        String profile = context.getEnvironment().getProperty("profile");
//        System.out.println(profile);

//        StringToUserPropertyEditor propertyEditor = new StringToUserPropertyEditor();
//        propertyEditor.setAsText("1");
//        User value = (User) propertyEditor.getValue();
//        System.out.println(value);
//        A a = new A();
//        B b = new B();
//        OrderComparator comparator = new OrderComparator();
//        int compare = comparator.compare(a, b);
//        List<Object> list = new ArrayList<>();
//        list.add(a);
//        list.add(b);
//        list.sort(comparator);

//        Object userService = context.getBean("userService");
//        System.out.println(userService);
//        SimpleMetadataReaderFactory simpleMetadataReaderFactory = new SimpleMetadataReaderFactory();
//        MetadataReader metadataReader = simpleMetadataReaderFactory.getMetadataReader("com.wy.spring.bean.UserService");
//        ClassMetadata classMetadata = metadataReader.getClassMetadata();
//        System.out.println(classMetadata.getClassName());
//
//        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
//        for (String annotationType : annotationMetadata.getAnnotationTypes()) {
//            System.out.println(annotationType);
//        }

    }
}
