package com.liao.sample.j2eebase.thread.aa;

public class CopyOfPerson {

	public static final int O=0;
	public static final int A=1;
	public static final int B=2;
	public static final int AB=3;
	
	private int _bloodGroup;
	public CopyOfPerson(int bloodGroup){
		_bloodGroup=bloodGroup;
	}
	public int get_bloodGroup() {
		return _bloodGroup;
	}
	public void set_bloodGroup(int _bloodGroup) {
		this._bloodGroup = _bloodGroup;
	}
	
}
