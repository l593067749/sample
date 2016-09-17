package com.liao.sample.j2eebase.thread.myThread;

public class MultiTreadShareData2 {

	static int count=100;
	public static void main(String[] args) {
		
		new Thread(new Runnable() {
			public void run() {
				while(count>0){
					System.out.println(Thread.currentThread().getName()+"-count:"+count);
					count--;
				}
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				while(count>0){
					System.out.println(Thread.currentThread().getName()+"-count:"+count);
					count--;
				}
			}
		}).start();
	}

}
