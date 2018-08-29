package com.king;

import com.king.config.MainConfig;
import com.king.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class IOCTest {
    @SuppressWarnings("resource")
    @Test
    public void test01(){
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = configApplicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames){
            System.out.println("name --->" + name);
        }
    }

    @Test
    public void test02(){
        // scope是单实例下，IOC容器启动会调用方法创建对象放到IOC容器中，scope = prototype时，不会
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] beanDefinitionNames = configApplicationContext.getBeanDefinitionNames();
        ConfigurableEnvironment environment = configApplicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println("property = " + property);
        for (String name : beanDefinitionNames){
            System.out.println("name --->" + name);
        }
        Object person = configApplicationContext.getBean("person");
        Object person2 = configApplicationContext.getBean("person");
        System.out.println("b = " + (person == person2));
    }

    @Test
    public void test03(){
        // scope是单实例下，IOC容器启动会调用方法创建对象放到IOC容器中，scope = prototype时，不会
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] beanDefinitionNames = configApplicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames){
            System.out.println("name --->" + name);
        }
    }




}
