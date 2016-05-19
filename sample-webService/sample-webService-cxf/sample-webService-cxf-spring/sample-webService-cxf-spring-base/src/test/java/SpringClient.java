import com.liao.sample.webservice.cxf.spring.IHelloWord;
import com.liao.sample.webservice.cxf.spring.impl.HelloWord;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 廖文强
 * @version V1.0
 * @Title: Client
 * @Package PACKAGE_NAME
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/5/18 17:58
 */
public class SpringClient {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-client.xml");

        IHelloWord helloService = context.getBean("IhelloWord", IHelloWord.class);
        String result = helloService.sayHello("world");
        System.out.println(result);
    }
}
