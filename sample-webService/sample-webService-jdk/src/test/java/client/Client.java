package client;

import com.liao.sample.webservice.jdk.IHelloWord;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author 廖文强
 * @version V1.0
 * @Title: Client
 * @Package PACKAGE_NAME
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/5/18 10:40
 */
public class Client {
    public static void main(String[] args) {
        try {
            URL url=new URL("http://localhost:8080/ws/hello?wsdl");
            QName serviceName=new QName("http://jdk.webservice.sample.liao.com/","HelloWordService");
            QName portName=new QName("http://jdk.webservice.sample.liao.com/","HelloWordPort");
            Service service= Service.create(url,serviceName);
            IHelloWord helloWord=service.getPort(portName, IHelloWord.class);
            String message=helloWord.sayHello("张三！");
            System.out.printf(message);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
