package com.king.bean;

import org.springframework.beans.factory.annotation.Value;

public class Person {
    // 使用@Value赋值
    /**
     * 1、基本数值
     * 2、可以写SpEL,#{}
     * 3、可以写${},取出配置文件【properties】中的值（在运行黄金变量里的值）
     */
    @Value("张三")
    private String name;
    @Value("#{20-3}")
    private Integer age;
    @Value("${person.nickname}")
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    public Person(){}
    public Person(String name,Integer age){
        this.name = name;
        this.age = age;
    }

}
