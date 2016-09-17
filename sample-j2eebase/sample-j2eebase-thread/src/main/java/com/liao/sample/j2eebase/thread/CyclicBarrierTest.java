package com.liao.sample.j2eebase.thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CyclicBarrierTest {

	public static void main(String[] args) {
	 ExecutorService service=Executors.newCachedThreadPool();
	 final CyclicBarrier cb=new CyclicBarrier(3);
	 for(int i=0;i<3;i++){
		 Runnable runnable=new Runnable() {
			public void run() {
				try {
					Thread.sleep((long)(Math.random()*1000));
					System.out.println("�߳�"+Thread.currentThread().getName()+"�������Ｏ�ϵ�1����ǰ����"+(cb.getNumberWaiting()+1));
					cb.await();
					Thread.sleep((long)(Math.random()*1000));
					System.out.println("�߳�"+Thread.currentThread().getName()+"�������Ｏ�ϵ�2����ǰ����"+(cb.getNumberWaiting()+1));
					cb.await();
					Thread.sleep((long)(Math.random()*1000));
					System.out.println("�߳�"+Thread.currentThread().getName()+"�������Ｏ�ϵ�3����ǰ����"+(cb.getNumberWaiting()+1));
					cb.await();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		service.execute(runnable);
		
	 }
	}

}
