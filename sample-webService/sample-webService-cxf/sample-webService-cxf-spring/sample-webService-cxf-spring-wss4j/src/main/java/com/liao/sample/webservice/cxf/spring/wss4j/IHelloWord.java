package com.liao.sample.webservice.cxf.spring.wss4j;

import javax.jws.WebService;

/**
 * @author 廖文强
 * @version V1.0
 * @Title: IHelloWord
 * @Package com.liao.sample.webservice.cxf.spring.wss4j
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/5/19 14:17
 */
@WebService
public interface IHelloWord {
    public String sayHello(String name);
}
