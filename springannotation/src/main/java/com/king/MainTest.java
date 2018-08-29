package com.king;

import com.king.bean.Person;
import com.king.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class MainTest {
    public static void main(String[] args) {
        // 配置方式
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.print("person--->" + person);
        // 注解式
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = configApplicationContext.getBean(Person.class);
        System.out.println("bean --->" + bean);
        // 获取Person.class文件在Spring容器中的名字
        String[] beanNamesForType = configApplicationContext.getBeanNamesForType(Person.class);
        for (String name: beanNamesForType){
            System.out.println("name --->" + name);
        }

    }
}
