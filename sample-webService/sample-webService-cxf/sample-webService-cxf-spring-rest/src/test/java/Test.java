import com.liao.sample.webservice.cxf.spring.rest.Product;
import com.liao.sample.webservice.cxf.spring.rest.ProductService;
import com.liao.sample.webservice.cxf.spring.rest.impl.ProductServiceImpl;

import java.util.List;

/**
 * Author liao
 * C or U by 2016/5/19-23:22
 * sample
 */
public class Test {
    public static void main(String[] args) {
        ProductService product=new ProductServiceImpl();
       List<Product> list=product.getAllProducts();
        for (Product p:list){
            System.out.println(p.getId());
        }
    }
}
