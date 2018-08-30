package com.king;

import com.king.config.MainConfigOfAutowired;
import com.king.dao.BookDao;
import com.king.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCAutowired {
    @Test
    public void test01(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        BookService bookService = (BookService)context.getBean(BookService.class);
        System.out.println(bookService.toString());
        System.out.println("====================================================================================");
//        BookDao bookDao = (BookDao) context.getBean("bookDao");
//        System.out.println("bookDao" + bookDao);
        context.close();
    }
}
