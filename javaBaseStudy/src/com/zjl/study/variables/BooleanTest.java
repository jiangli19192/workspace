package com.zjl.study.variables;

public class BooleanTest {
	
	public static void main(String[] args) {
		BooleanTest test = new BooleanTest();
		test.testMethodParameterIsBoolean();
		
		test.testMethodParameterIsObject();
	}

	/**
	 * 测试方法参数是Boolean类型的形式参数
	 */
	public void testMethodParameterIsBoolean() {
		Boolean boo = Boolean.FALSE;
		Integer int1 = new Integer(200000000);

		changeParameterValueToTrue(boo, int1);
		System.out.println("boolean boo = " + boo);
		System.out.println("Integer int1 = " + int1);
	}

	/**
	 * 测试方法参数是Object类型的形式参数
	 */
	public void testMethodParameterIsObject() {
		DataClass dataClass = new DataClass();
		changeClassValueToTrue(dataClass);
		System.out.println("boolean boo = " + dataClass.isBoo2());
		System.out.println("Integer int1 = " + dataClass.getInt2());
	}

	public void changeParameterValueToTrue(Boolean boo, Integer int1) {
		boo = true;
		int1 = 2;
		System.out.println("already execute this operation");
	}
	
	public void changeClassValueToTrue(DataClass dataClass) {
		dataClass.setBoo2(true);
		dataClass.setInt2(2);
		System.out.println("Class already execute this operation");
	}
}

class DataClass{
	private boolean boo2 = false;
	private int int2 = 1;
	
	boolean isBoo2() {
		return boo2;
	}
	void setBoo2(boolean boo2) {
		this.boo2 = boo2;
	}
	int getInt2() {
		return int2;
	}
	void setInt2(int int2) {
		this.int2 = int2;
	}
}
