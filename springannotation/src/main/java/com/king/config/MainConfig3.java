package com.king.config;

import com.king.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// 引用外部配置文件,加载到环境变量中
@PropertySource(value = {"classpath:/person.properties"})
// 配置类
@Configuration
public class MainConfig3 {
    @Bean("person")
    public Person person(){
        return new Person();
    }
}
