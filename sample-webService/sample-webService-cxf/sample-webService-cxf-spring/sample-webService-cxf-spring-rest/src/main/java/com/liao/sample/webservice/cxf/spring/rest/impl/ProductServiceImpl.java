package com.liao.sample.webservice.cxf.spring.rest.impl;

import com.liao.sample.webservice.cxf.spring.rest.Product;
import com.liao.sample.webservice.cxf.spring.rest.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.ws.rs.PathParam;
import java.util.*;


/**
 * Author liao
 * C or U by 2016/5/19-22:43
 * sample
 */
@Service
public class ProductServiceImpl implements ProductService {
    public  static  List<Product> productList = new ArrayList<Product>();

    static {
        productList.add(new Product(1, "iphone 5s", 5000));
        productList.add(new Product(2, "ipad mini", 2500));
        productList.add(new Product(3, "3", 3000));
    }

    public List<Product> getAllProducts() {
        Collections.sort(productList, new Comparator<Product>() {
            public int compare(Product o1, Product o2) {
                return o1.getId()>o2.getId()?1:-1;
            }
        });
        return productList;
    }

    public Product getProduct(long id) {
        Product product=null;
        for(Product product1:productList){
            if(product1.getId()==id){
                product=product1;
            }
        }
        return product;
    }

    public String sayHello(String name) {
        return "hello:"+name;
    }

    public long addProduct(Product product) {
        productList.add(product);
        return product.getId();
    }


    public long addProduct2(Product product) {

        product.setName((String) product.getParams().get("name"));
        productList.add(product);
        return 0;
    }

    public Product updateProduct(Product product) {
        Product oldProduct= this.getProduct(product.getId());
        oldProduct.setName(product.getName());
        oldProduct.setPrice(product.getPrice());
        return oldProduct;
    }

    public void deleteCustomer(long id) {
       Iterator<Product> lists=productList.iterator();
        while(lists.hasNext()){
            Product product= lists.next();
            if(product.getId()==id){
                lists.remove();
            }
        }
    }
}
