package com.liao.sample.j2eebase.thread.aa;

public class CopyOfBloodGroup {
	public static final CopyOfBloodGroup O=new CopyOfBloodGroup(0);
	public static final CopyOfBloodGroup A=new CopyOfBloodGroup(1);
	public static final CopyOfBloodGroup B=new CopyOfBloodGroup(2);
	public static final CopyOfBloodGroup AB=new CopyOfBloodGroup(3);
	private static final CopyOfBloodGroup[] _values={O,A,B,AB};
	private final int _code;
	private CopyOfBloodGroup(int code){
		_code=code;
	}
	public int getCode(){
		return _code;
	}
	public static CopyOfBloodGroup code(int arg){
		return _values[arg];
	}
}

