package com.liao.sample.j2eebase.generic.test01;

import sun.applet.Main;

/**
 * Author liao
 * C or U by 2016/6/16-23:10
 * sample
 */
public class TwoTuple<A,B> {
    public final A a;
    public final B b;
    public TwoTuple(A a,B b){
        this.a=a;
        this.b=b;
    }
    public String toString(){
        return a+"-"+b;
    }

    public static void main(String[] args) {
       String str= new TwoTuple<String,Integer>("tom",100).toString();
        System.out.println(str);
    }
}
