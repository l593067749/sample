package com.liao.sample.quartz.base.b01.Job;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

/**
 * Author liao
 * C or U by 2016/5/25-23:23
 * sample
 */
public class MySpringJobTest {
    public static void main(String[] args) {
        ApplicationContext xml=new ClassPathXmlApplicationContext("classpath:spring-3.xml");
        System.out.println("请输入信息：");
        Scanner input=new Scanner(System.in);
        int x=input.nextInt();
        System.out.println(x);
        System.out.print("Test end..");
    }
}
