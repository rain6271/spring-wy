package org.springframework.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan(basePackages = "org.springframework.aop")
@EnableAspectJAutoProxy
@Configuration
public class AopConfig {

}
