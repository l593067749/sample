package com.liao.sample.webservice.cxf.base.impl;

import com.liao.sample.webservice.cxf.base.IHelloWord;

import javax.jws.WebService;

/**
 * @author 廖文强
 * @version V1.0
 * @Title: HelloWord
 * @Package com.liao.sample.webservice.cxf.base
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/5/18 15:32
 */
@WebService
public class HelloWord implements IHelloWord {
    public String sayHello(String name) {
        return "hello: "+name;
    }
}
