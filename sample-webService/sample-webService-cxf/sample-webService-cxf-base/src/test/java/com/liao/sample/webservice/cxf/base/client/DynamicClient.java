package com.liao.sample.webservice.cxf.base.client;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsClientFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * @author 廖文强
 * @version V1.0
 * @Title: jaxWsClient
 * @Package com.liao.sample.webservice.cxf.base.service
 * @Description: 通用动态客户端
 * @date 2016/5/18 15:55
 */
public class DynamicClient {
    public static void main(String[] args) {
        JaxWsDynamicClientFactory factory=JaxWsDynamicClientFactory.newInstance();
        Client client=factory.createClient("http://localhost:8080/ws/hello?wsdl");
        try {
            Object[] result= client.invoke("sayHello","张三");
            System.out.println(result[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
