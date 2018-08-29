package com.king;

import com.king.service.FundService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    public static void main(String[] args) {
        // 注解式
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        FundService fundService = (FundService) applicationContext.getBean("fundService");
        fundService.saveFundInfo("003075",6);


        System.out.println("-----------------------------------");
        fundService.isHBFund();
    }
}
