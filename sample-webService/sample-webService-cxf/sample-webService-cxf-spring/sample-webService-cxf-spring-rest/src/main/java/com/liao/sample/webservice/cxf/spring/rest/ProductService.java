package com.liao.sample.webservice.cxf.spring.rest;

import javax.ws.rs.*;
import java.util.List;

/**
 * Author liao
 * C or U by 2016/5/19-22:36
 * sample
 */
@Produces("application/json;charset=UTF-8")
public interface ProductService {

    @GET
    @Path("/products/")
    List<Product> getAllProducts();

    @GET
    @Path("/product/{id}/")
    Product getProduct(@PathParam("id")long id);

    @GET
    @Path("/product/say/{name}/")
    String sayHello(@PathParam("name")String name);

    @POST
    @Path("/product/add")
    @Consumes("application/json;charset=UTF-8")
    long  addProduct(Product product);

    @POST
    @Path("/product/add2")
    @Consumes("application/json;charset=UTF-8")
    //long  addProduct2(Product product, @RequestParam("param") Map<String,Object>  param);
    //long  addProduct2(Product product, @RequestBody  Map<String,Object>  param);
    long  addProduct2(Product product);

    @POST
    @Path("/product/update")
    @Consumes("application/json;charset=UTF-8")
    Product updateProduct(Product product);

    @DELETE
    @Path("/customers/{id}/")
    void deleteCustomer(@PathParam("id") long id);


}
