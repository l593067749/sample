import com.liao.sample.webservice.cxf.spring.rest.Product;
import com.liao.sample.webservice.cxf.spring.rest.ProductService;
import com.liao.sample.webservice.cxf.spring.rest.ResponseBaseEntity;
import com.liao.sample.webservice.cxf.spring.rest.impl.ProductServiceImpl;
import com.sample.httpclient.resttemplate.spring.RestClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpMessageConverterExtractor;

import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Author liao
 * C or U by 2016/5/19-23:22
 * sample
 */
public class Test {
    public static void main(String[] args) {
        Test test=new Test();

       /* //
        System.out.println(new Test().getProduct(new Long(0)));
        System.out.println(new Test().getProducts().get(0));
        // 封装好的
        System.out.println(new Test().getProduct2(new Long(1)));

        //删除
        test.del(new Long(1));*/

        /*long newId=test.addProduct();
        System.out.println(test.getProduct(newId));
        test.updateProduct(new Product(1,"修改一下",200));*/

        test.addProduct2();


    }

    public void test1(){
        ProductService product=new ProductServiceImpl();
        List<Product> list=product.getAllProducts();
        for (Product p:list){
            System.out.println(p.getId());
        }
    }
    public List<Product> getProducts(){
        String url="http://localhost:8080/ws/rest/products";
        List<Product> result= RestClient.getClient().getForObject(url,List.class,"");
        return result;

    }

    public Product getProduct(Long id){
        String url="http://localhost:8080/ws/rest/product/"+id;
        Product product=RestClient.getClient().getForObject(url,Product.class,id);
        return product;
    }

    public Product getProduct2(Long id){
        String url="http://localhost:8080/ws/rest/product/"+id;
        Product product=RestClient.exchange(url,HttpMethod.GET,Product.class,id);
        return product;
    }

    public long addProduct() {
        Long id = new Random(1000).nextLong();
        String url = "http://localhost:8080/ws/rest/product/add";
        Product product = new Product(id, "新增一个id为：" + id, 100);
        id=RestClient.getClient().postForObject(url,product,Long.class);
        id=RestClient.exchange(url,HttpMethod.POST,product,Long.class,"");
        return id;
    }

    public long addProduct2() {
        Long id = new Random(1000).nextLong();
        String url = "http://localhost:8080/ws/rest/product/add2";
        Product product = new Product(id, "新增一个id为：" + id, 100);
        Map<String,Object> param=new HashMap<String,Object>();
        param.put("name","这map起作用了");
        product.setParams(param);
        id=RestClient.exchange(url,HttpMethod.POST,product,Long.class, param);
        return id;
    }

    public Product updateProduct(Product product){
        String url = "http://localhost:8080/ws/rest/product/update";
        Product newProduct=RestClient.exchange(url,HttpMethod.POST,product,Product.class);
        return newProduct;
    }
    public void del(Long id){
        String url = "http://localhost:8080/ws/rest/customers/"+id;
        RestClient.exchange(url, HttpMethod.DELETE, Long.class, "");
    }

    public void aa(){
        String url="http://localhost:8080/ws/rest/products";
        String mesage= RestClient.exchange(url,HttpMethod.GET,String.class,"123");
        System.out.println(mesage);
    }
}
