package com.liao.sample.webservice.cxf.spring.rest.impl;

import com.liao.sample.webservice.cxf.spring.rest.Product;
import com.liao.sample.webservice.cxf.spring.rest.ProductService;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * Author liao
 * C or U by 2016/5/19-22:43
 * sample
 */
@Service
public class ProductServiceImpl implements ProductService {
    private static final List<Product> productList = new ArrayList<Product>();

    static {
        productList.add(new Product(1, "iphone 5s", 5000));
        productList.add(new Product(2, "ipad mini", 2500));
    }

    public List<Product> getAllProducts() {
        Collections.sort(productList, new Comparator<Product>() {
            public int compare(Product o1, Product o2) {
                return o1.getId()>o2.getId()?1:-1;
            }
        });
        return productList;
    }
}
