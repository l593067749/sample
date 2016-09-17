package com.liao.sample.j2eebase.thread.myThread;

public class MultiTreadShareData3 {
	
	public static void main(String[] args) {
		 ShareData3 sd=new ShareData3();
		new Thread(new MyRunnable(sd)).start();
		new Thread(new MyRunnable2(sd)).start();
		
	}
	
	
}
class ShareData3{
	private int j=0;
	synchronized void add(){
		while(j<100){
			j++;
			System.out.println(Thread.currentThread().getName()+"--"+j);
		}
		
	}
	synchronized void del(){
		 while(j>0){
			 j--;
			 System.out.println(Thread.currentThread().getName()+"--"+j);
		 }
		
	}
}
class MyRunnable implements Runnable{
	private ShareData3 data3;
	public MyRunnable(ShareData3 data3){
		this.data3=data3;
	}
	public void run() {
		data3.add();
	}
}
class MyRunnable2 implements Runnable{
	private ShareData3 data3;
	public MyRunnable2(ShareData3 data3){
		this.data3=data3;
	}
	public void run() {
		data3.del();
	}
}


