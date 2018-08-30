package com.king.config;

import com.king.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 自动装配；
 *          spring利用依赖注入（DI）,完成对ioc容器中各个组件的依赖关系赋值
 *          1) @Autowired ,自动注入
 *          ①默认是按照类型去容器中找对应的组件：context.getBean(BookService.class);
 *          ②如果找到多个相同类型的组件，再将属性的名称作为id去容器中查找;
 *          ③@Qualifier("bookDao"),使用@Qualifier指定需要装配的组件id，而不是使用属性名
 *          ④自动装配默认一定要将属性赋值好，没有就会报错
 *          可以使用 @Autowired(required = false)
 *          2）spring还支持使用@resource（JSR250）和@inject（JRS330）【java规范】
 *          @Resource
 *              可以和@Autowired一样实现自动自动装配，默认是按照组件名称进行装配；
 *
 *
 */
// 配置类
@Configuration

@ComponentScan({"com.king.service","com.king.dao","com.king.controller"})
public class MainConfigOfAutowired {
    @Bean("bookDao")
    public BookDao bookDao(){
        BookDao bookDao = new BookDao();
        bookDao.setLabel("2");
        return bookDao;
    }



}
