package com.king;

import com.king.bean.Person;
import com.king.config.MainConfig3;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class IOCPropertyValue {
    @Test
    public void test(){
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(MainConfig3.class);
        String[] beanDefinitionNames = configApplicationContext.getBeanDefinitionNames();
        for (String name :beanDefinitionNames){
            System.out.println("beanName = " + name);
        }
        Person person = (Person) configApplicationContext.getBean("person");
        System.out.println("name = " + person.getName());
        System.out.println("age = " + person.getAge());
        System.out.println("nickname = " + person.getNickname());
        System.out.println("=================================================");
        ConfigurableEnvironment environment = configApplicationContext.getEnvironment();
        String property = environment.getProperty("person.nickname");
        System.out.println("property = " + property);
    }
}
