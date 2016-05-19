package com.liao.sample.webservice.cxf.spring.impl;

import com.liao.sample.webservice.cxf.spring.IHelloWord;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * @author 廖文强
 * @version V1.0
 * @Title: HelloWord
 * @Package com.liao.sample.webservice.cxf.spring
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/5/18 16:46
 */
@WebService(targetNamespace = "http://spring.cxf.webservice.sample.liao.com/")
@Component
public class HelloWord implements IHelloWord {

    public String sayHello(String name) {
        return "hello:"+name;
    }
}
