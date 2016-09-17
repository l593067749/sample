package com.liao.sample.j2eebase.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadeWriteLockTest {

	public static void main(String[] args) {
		final Person ps = new Person();
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				public void run() {
					while(true){
						ps.save();
					}
				}
			}).start();
			new Thread(new Runnable() {
				public void run() {
					while(true){
						ps.get();
					}
				}
			}).start();
		}
	}

	public static Map<String,String> map=new HashMap<String,String>();
	public String get(String key){
		if(null!=map.get(key)){
			return map.get(key);
		}else{
			map.put(key, "aaa");
			return map.get(key);
		}
	}
	
	public synchronized String get2(String key){
		if(null!=map.get(key)){
			return map.get(key);
		}else{
			map.put(key, "aaa");
			return map.get(key);
		}
	}
	/**
	 * ��д������
	 * д��д����
	 * �����������
	 */
	final ReadWriteLock rwl=new ReentrantReadWriteLock();
	public String get3(String key){
		//�϶���
		rwl.readLock().lock();
		try{
			if(null==map.get(key)){
				//ȡ������
				rwl.readLock().unlock();
				//����д����ֻ�ж���ȡ���˲��ܴ���д����
				rwl.writeLock().lock();
				try {
					if(null!=map.get(key)){
						map.put(key, "aaa");
					}
				} catch (Exception e) {
				}finally{
					//д���˺�ȡ��д��
					rwl.writeLock().unlock();
				}
				//��������
				rwl.readLock().lock();
			}
		}catch(Exception e){
			
		}finally{
			//�رն���
			rwl.readLock().unlock();
		}
		return map.get(key);
	}
	
	
	static class Person {
		ReadWriteLock rwl = new ReentrantReadWriteLock();
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void save() {
			rwl.readLock().lock();
			System.out.println(Thread.currentThread().getName()+"�������ڶ�����������");
			try {
				Thread.sleep(new Random().nextInt(1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"���Ҷ�����-" + this.getName());
			rwl.readLock().unlock();
		}

		public String get() {
			rwl.writeLock().lock();
			System.out.println(Thread.currentThread().getName()+"�����C��д����������");
			try {
				Thread.sleep(new Random().nextInt(1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.setName(""+new Random().nextInt(100));
			System.out.println(Thread.currentThread().getName()+"���Ҍ�����");
			rwl.writeLock().unlock();
			return "";
		}
	}
}
