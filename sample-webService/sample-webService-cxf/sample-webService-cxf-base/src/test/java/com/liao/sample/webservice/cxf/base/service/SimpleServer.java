package com.liao.sample.webservice.cxf.base.service;

import com.liao.sample.webservice.cxf.base.IHelloWord;
import com.liao.sample.webservice.cxf.base.impl.HelloWord;
import org.apache.cxf.frontend.ServerFactoryBean;

/**
 * @author 廖文强
 * @version V1.0
 * @Title: SimpleServer
 * @Package com.liao.sample.webservice.cxf.base.service
 * @Description: simple 方式
 * @date 2016/5/18 16:12
 */
public class SimpleServer {
    public static void main(String[] args) {
        ServerFactoryBean factory=new ServerFactoryBean();
        factory.setAddress("http://localhost:8080/ws/hello");
        factory.setServiceClass(IHelloWord.class);
        factory.setServiceBean(new HelloWord());
        factory.create();
        System.out.println("simple Service started!");
    }
}
