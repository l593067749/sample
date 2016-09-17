package com.liao.sample.j2eebase.generic.test01;

/**
 * 传统的下推堆栈
 * Author liao
 * C or U by 2016/6/16-23:23
 * sample
 */
public class LinkedStack<T> {
    private static class Node<U>{
        U item;
        Node<U> next;
        Node(){
            item=null;
            next=null;
        }
        Node(U item,Node<U> next){
            this.item=item;
            this.next=next;
        }
        boolean isEnd(){return item==null&&next==null;}
    }
    private Node<T> top=new Node<T>();
    public void push(T item){
        top=new Node<T>(item,top);
    }
    public T pop(){
        T result=top.item;
        if(!top.isEnd()){
            top=top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> lss=new LinkedStack<String>();
        for(String s:"abc or cdf!".split(" ")){
            lss.push(s);
        }
        String s;
        while((s=lss.pop())!=null){
            System.out.println(s);
        }
    }
}
