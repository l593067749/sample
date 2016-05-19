package com.liao.sample.webservice.jdk;

import javax.jws.WebService;

/**
 * @author 廖文强
 * @version V1.0
 * @Title: IHelloWord
 * @Package PACKAGE_NAME
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/5/18 10:24
 */
@WebService
public interface IHelloWord {
    public String sayHello(String name);
}
