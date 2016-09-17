package com.liao.sample.j2eebase.thread.myThread;

public class MultiTreadShareData {

	
	public static void main(String[] args) {
		ShareData sd=new ShareData();
		new Thread(sd).start();
		new Thread(sd).start();
		new Thread(sd).start();
		new Thread(sd).start();
	}

}
class ShareData implements Runnable{
	private int count=100;
	public void run() {
		{
			while(count>0){
				System.out.println(Thread.currentThread().getName()+"-count:"+count);
				count--;
			}
		}
		
	}
	
}