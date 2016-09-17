package com.liao.sample.j2eebase.thread;

public class FinallyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println("bb");
			return;
		} catch (Exception e) {
		}finally{
			System.out.println("aa");
		}
	}
	
	public static String aa(){
		return "aa";
	}

}
