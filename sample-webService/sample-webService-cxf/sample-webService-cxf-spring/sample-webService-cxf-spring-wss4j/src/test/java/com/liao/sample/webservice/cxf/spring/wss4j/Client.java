package com.liao.sample.webservice.cxf.spring.wss4j;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 廖文强
 * @version V1.0
 * @Title: Client
 * @Package com.liao.sample.webservice.cxf.spring.wss4j
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/5/19 14:37
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring-client-3.xml");
        IHelloWord helloWord=context.getBean("IHelloWord",IHelloWord.class);
        String message=helloWord.sayHello("张三");
        System.out.println(message);
    }
}
