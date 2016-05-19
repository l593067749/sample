package com.liao.sample.webservice.jdk.impl;

import com.liao.sample.webservice.jdk.IHelloWord;

import javax.jws.WebService;

/**
 * @author 廖文强
 * @version V1.0
 * @Title: HelloWrod
 * @Package PACKAGE_NAME
 * @Description: 这里发布的时候要用接口所用的包名
 * @date 2016/5/18 10:27
 */
//@WebService()
@WebService(targetNamespace = "http://jdk.webservice.sample.liao.com/")
public class HelloWord implements IHelloWord {

    @Override
    public String sayHello(String name) {
        return "hello :"+name;
    }
}
