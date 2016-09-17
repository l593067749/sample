package com.liao.sample.j2eebase.generic.test01;

/**
 * Author liao
 * C or U by 2016/6/16-22:22
 * sample
 */
public class Test<T> {
    private T t;
    public Test(T t){
        this.t=t;
    }
    public T get(){
        return t;
    }
    public void set(T t){
        this.t=t;
    }

    public static void main(String[] args) {
        Test<String> test=new Test<String>("100");
        test.set(200+"");
        System.out.println(test.get());


    }
}
