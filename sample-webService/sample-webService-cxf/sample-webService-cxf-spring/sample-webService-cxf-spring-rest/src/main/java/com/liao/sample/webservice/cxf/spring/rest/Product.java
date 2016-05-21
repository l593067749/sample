package com.liao.sample.webservice.cxf.spring.rest;

import java.util.Map;

public class Product {

    private long id;
    private String name;
    private int price;

    public Map<String,Object> params;


    public Product() {
    }

    public Product(long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String toString(){
        return "id:"+id+"{"+"name:"+name+"price:"+price+"}";
    }
}
