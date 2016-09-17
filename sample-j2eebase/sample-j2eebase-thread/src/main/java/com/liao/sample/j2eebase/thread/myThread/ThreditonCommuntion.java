package com.liao.sample.j2eebase.thread.myThread;

public class ThreditonCommuntion {
	  
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*synchronized (ThreditonCommuntion.class) {
		for(int i=0;i<50;i++){
			for(int j=1;j<=10;j++){
				System.out.println("main thread "+i+"-"+j);
			}
		}
		}
		
		new Thread(new Runnable() {
			public void run() {
				synchronized (ThreditonCommuntion.class) {
					for(int i=0;i<50;i++){
						for(int j=1;j<=10;j++){
							System.out.println("sub thread "+i+"-"+j);
						}
					}
				}
			}
		}).start();*/
		final Businesss bs=new Businesss();
		
		for(int i=1;i<50;i++){
			bs.main(i);
		}
		new Thread(new Runnable() {
			public void run() {
					for(int i=0;i<50;i++){
						bs.sub(i);
					}
			}
		}).start();
		
	}
	
}
class Businesss{
	private boolean goSub=true;
	public synchronized void main(int i){
		while(goSub){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int j=1;j<10;j++){
			System.out.println("main thread i:"+i+"---"+j);
		}
		goSub=true;
		this.notify();
	}
	public synchronized void sub(int i){
		while(!goSub){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int j=1;j<10;j++){
			System.out.println("sub thread i:"+i+"---"+j);
		}
		goSub=false;
		this.notify();
	}
}
