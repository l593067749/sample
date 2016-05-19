package com.liao.sample.webservice.cxf.spring.wss4j.impl;

import com.liao.sample.webservice.cxf.spring.wss4j.IHelloWord;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * @author 廖文强
 * @version V1.0
 * @Title: HelloWord
 * @Package com.liao.sample.webservice.cxf.spring.wss4j
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/5/19 14:19
 */
@WebService(targetNamespace = "http://wss4j.spring.cxf.webservice.sample.liao.com/")
@Component
public class HelloWord implements IHelloWord {
    public String sayHello(String name) {
        return "hello:"+name;
    }
}
