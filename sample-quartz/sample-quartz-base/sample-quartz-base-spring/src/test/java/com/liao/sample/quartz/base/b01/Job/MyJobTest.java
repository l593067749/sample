package com.liao.sample.quartz.base.b01.Job;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author liao
 * C or U by 2016/5/25-23:23
 * sample
 */
public class MyJobTest {
    public static void main(String[] args) {
        ApplicationContext xml=new ClassPathXmlApplicationContext("classpath:spring.xml");
    }
}
