package com.king.config;

import com.king.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

// 配置类 == 配置文件
@Configuration      // 告诉Spring这是一个配置类，不用xml配置自动扫描
//@ComponentScan(value = "com.king",excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class
//)})
@ComponentScan(value = "com.king",includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Service.class)},useDefaultFilters = false)
// @ComponentScan value : 指定要扫描的包
// excludeFilters = Filter[] ,指定扫描的时候按照什么规则排除哪些组件
// includeFilters = Filter[], 指定扫描的时候只需要包含哪些组件,特别注意：useDefaultFilters = false
public class MainConfig {
    // 给容器注册一个Bean，类型为返回值的类型，id默认用方法名作为id
    @Bean("person") // 指定名字
    public Person person01(){
        return new Person("king",18);
    }

}
