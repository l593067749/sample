import org.apache.cxf.endpoint.*;
import org.apache.cxf.endpoint.dynamic.DynamicClientFactory;

/**
 * @author 廖文强
 * @version V1.0
 * @Title: DyClient
 * @Package PACKAGE_NAME
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/5/19 9:27
 */
public class DynamicClientFactoryClient {
    public static void main(String[] args) {
        DynamicClientFactory factory=DynamicClientFactory.newInstance();
        Client client= factory.createClient("http://localhost:8080/ws/soap/hello?wsdl");
        try {
            Object[] objects=client.invoke("sayHello","张三");
            System.out.println(objects[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
