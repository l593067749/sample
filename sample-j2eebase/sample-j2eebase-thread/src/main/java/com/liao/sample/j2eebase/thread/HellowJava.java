package com.liao.sample.j2eebase.thread;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;


public class HellowJava {

	private String aa;
	private String bb;
	private String cc;
	public String getAa(){return this.aa;}
	public void setAa(String aa){this.aa=aa;}
	public HellowJava(){};
	public HellowJava(String aa,String bb){this.aa=aa;this.bb=bb;};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("��ȥ��İѣ�");
		System.out.println(new HellowJava().getAa());
		try {
			Class hellowJava=Class.forName("HellowJava");
			
			HellowJava hj1= (HellowJava)hellowJava.newInstance();
			hj1.setAa("aa");
			
			Method[] methods=hellowJava.getDeclaredMethods();
			Field[] fields=hellowJava.getDeclaredFields();
			System.out.println(Arrays.toString(fields));
			System.out.println(Arrays.toString(methods));
			System.out.println(Arrays.toString(hellowJava.getConstructors()));
			System.out.println(hellowJava.getModifiers());
			System.out.println(hellowJava.getName());
			System.out.println(hellowJava.getSimpleName());
			System.out.println(hellowJava.getResource(""));
			System.out.println(hellowJava.getProtectionDomain());
			System.out.println(hj1.aa);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
	

}
