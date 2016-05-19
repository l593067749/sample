package com.liao.sample.webservice.cxf.base.service;

import com.liao.sample.webservice.cxf.base.IHelloWord;
import com.liao.sample.webservice.cxf.base.impl.HelloWord;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
 * @author 廖文强
 * @version V1.0
 * @Title: JaxWsServer
 * @Package com.liao.sample.webservice.cxf.base
 * @Description: jax 方式
 * @date 2016/5/18 15:36
 */
public class JaxWsServer {

    public static void main(String[] args) {
        JaxWsServerFactoryBean factory=new JaxWsServerFactoryBean();
        factory.setAddress("http://localhost:8080/ws/hello");
        //这里传的是什么，接口/实现类 的注解（属性值）就起作用
        factory.setServiceClass(IHelloWord.class);
        factory.setServiceBean(new HelloWord());
        factory.create();
        System.out.println("service started！");
    }


}
