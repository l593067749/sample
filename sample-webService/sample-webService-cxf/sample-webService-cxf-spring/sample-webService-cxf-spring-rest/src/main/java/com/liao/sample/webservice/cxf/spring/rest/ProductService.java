package com.liao.sample.webservice.cxf.spring.rest;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Author liao
 * C or U by 2016/5/19-22:36
 * sample
 */
public interface ProductService {

    @GET
    @Path("/products")
    @Produces(MediaType.APPLICATION_JSON)
    List<Product> getAllProducts();


}
