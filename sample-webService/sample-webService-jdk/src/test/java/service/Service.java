package service;

import com.liao.sample.webservice.jdk.IHelloWord;
import com.liao.sample.webservice.jdk.impl.HelloWord;

import javax.xml.ws.Endpoint;

/**
 * @author 廖文强
 * @version V1.0
 * @Title: Service
 * @Package PACKAGE_NAME
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/5/18 10:33
 */
public class Service {
    public static void main(String[] args) {
        String address="http://localhost:8080/ws/hello";
        Endpoint.publish(address,new HelloWord());
        System.out.printf("service started!");
    }
}
