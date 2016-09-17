package com.liao.sample.j2eebase.thread;

import java.util.Random;


public class ThreadLocalTest {
	static int a=5;
	
	public static void main(String[] args) {
		final ThreadLocal<Integer> tl=new ThreadLocal<Integer>();
		new Thread(new Runnable() {
			public void run() {
				a=new Random().nextInt();
				tl.set(a);
				for(int i=0;i<20;i++){
					System.out.println(Thread.currentThread().getName()+":"+tl.get()+"-"+a);
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				a=new Random().nextInt();
				tl.set(a);
				for(int i=0;i<20;i++){
					System.out.println(Thread.currentThread().getName()+":"+tl.get()+"-"+a);
				}
			}
		}).start();
		
	}

}
