package com.king.config;

import com.king.bean.Color;
import com.king.bean.Person;
import com.king.bean.Red;
import com.king.bean.Yellow;
import com.king.condition.LiunxCondition;
import com.king.condition.MyImportSelector;
import com.king.condition.WindowsCondition;
import org.springframework.context.annotation.*;

@Configuration
@Import(value = {Color.class, Red.class, MyImportSelector.class})
// @Import 导入组件，id默认是组件全类名
public class MainConfig2 {
    /**
     * prototype 多实例的，IOC启动不会调用方法创建对象放到容器中，每次获取的时候才会调用方法创建对象
     * singleton 单实例的（默认值），IOC容器启动会调用方法创建对象放到IOC容器中，以后每次获取就是直接从容器中拿
     * request 同一次请求创建一个实例
     * session 同一个session创建一个实例
     *
     * 懒加载：
     *       单实例bean，默认在容器启动的时候创建对象；
     *       懒加载，容器启动不创建对象，第一次使用（获取）Bean创建对象，并初始化，线程不安全
     * @return
     */
    // 默认是单实例
//    @Scope("prototype")// 多实例
//    @Lazy
//    @Bean("person") // 指定名字
//    public Person person(){
//        System.out.println("给容器中添加Person...");
//        return new Person("aking",20);
//    }

    // @Conditional
    @Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person person01(){
        return new Person("bill gates",65);
    }
    @Conditional({LiunxCondition.class})
    @Bean("tom")
    public Person person02(){
        return new Person("tomcat",48);
    }

    /**
     * 给容器中注册组件
     * 1、 包扫描 + 组件标注注解 （@Controller 、@Service、@Repository、@Component）
     * 2、 @Bean 【导入的第三方包里面的组件】
     * 3、@import 【快速给容器中导入一个组件】
     *      1）@import（要导入到容器中的组件），容器中就会自动注册这个组件，id默认是全类名
     *      2）ImportSelector :返回需要导入的组件的全类名数组
     *      3）
     */

}

