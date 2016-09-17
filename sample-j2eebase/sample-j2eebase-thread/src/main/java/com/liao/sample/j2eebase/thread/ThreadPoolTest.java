package com.liao.sample.j2eebase.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class ThreadPoolTest {

	public static void main(String[] args) {
		//�����̶���С ��3���̵߳��̳߳�
		//ExecutorService threadPool=Executors.newFixedThreadPool(3);
		//���������̳߳�
		//ExecutorService threadPool=Executors.newCachedThreadPool();
		//��һ���̳߳�
		ExecutorService threadPool=Executors.newSingleThreadExecutor();
		for(int i=0;i<=10;i++){
			final int task=i;
			//��������̳߳���ִ������
			threadPool.execute(new Runnable(){
				public void run() {
					for(int j=1;j<10;j++){
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName()+"]-i:"+task+" task:"+j);
					}
				}
				
			});
			
			
		}
		System.out.println("------------");
		//threadPool.shutdown();
		
		Executors.newScheduledThreadPool(3).schedule(new Runnable() {
			public void run() {
			System.out.println("bombing!");
			}
		}, 5, TimeUnit.SECONDS);
	}

}
