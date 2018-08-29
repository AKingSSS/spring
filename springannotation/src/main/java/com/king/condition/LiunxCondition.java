package com.king.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LiunxCondition implements Condition {
    /**
     *
     * @param conditionContext 判断条件使用的上下文（环境）
     * @param annotatedTypeMetadata 注释信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        // 1、能获取IOC使用的beanfactor
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        // 2、能获取到类加载器
        ClassLoader classLoader = conditionContext.getClassLoader();
        // 3、获取运行环境
        Environment environment = conditionContext.getEnvironment();
        // 4、获取bean定义的注册类
        BeanDefinitionRegistry registry = conditionContext.getRegistry();
        String property = environment.getProperty("os.name");
        if (!property.contains("Windows")){
            return true;
        }
        return false;
    }
}
