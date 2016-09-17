package com.liao.sample.j2eebase.thread.aa;

public class Person {

	public static final int O=BloodGroup.O.getCode();
	public static final int A=BloodGroup.A.getCode();
	public static final int B=BloodGroup.B.getCode();
	public static final int AB=BloodGroup.AB.getCode();
	
	private BloodGroup _bloodGroup;
	public Person(int bloodGroup){
		_bloodGroup=BloodGroup.code(bloodGroup);
	}
	public int getBloodGroup() {
		return _bloodGroup.getCode();
	}
	public void setBloodGroup(int arg) {
		this._bloodGroup = BloodGroup.code(arg);
	}
	
}
