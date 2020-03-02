package com.zjl.study.operator;


public class BooleanTest {
	public static void main(String[] args) {
		
//		System.out.println(true || false && true);
//		System.out.println(false || true && true);
//		System.out.println(false || false && true);
		
		
		
		System.out.println(true || getTrue_1() && getTrue_2());
		System.out.println("------------------------------------------");
		System.out.println(false || getTrue_1() && getTrue_2());
		System.out.println("------------------------------------------");
		System.out.println(getTrue_1() && getTrue_2() || getFalse_1());
		System.out.println("------------------------------------------");
		example_1();
	}
	
	public static boolean getTrue_1() {
		System.out.println("True_1");
		return 1 == 1;
	}
	
	public static boolean getTrue_2() {
		System.out.println("True_2");
		return 2 == 2;
	}

	public static boolean getFalse_1() {
		System.out.println("False_1");
		return 1 == 2;
	}
	
	public static boolean getFalse_2() {
		System.out.println("False_2");
		return 1 == 2;
	}
	
	public static boolean getFalse_3() {
		System.out.println("False_3");
		return 1 == 2;
	}
	
	public static void example_1 () {
		boolean dd = false;
        boolean cc = true;
        if (true || (dd=true) == false && (cc=false) ==false){
        	System.out.println("if condition is true");
        }
        System.out.println("------------------------------------------");
        
        if (false || (dd=getTrue_2()) == getFalse_1() && (cc=getFalse_2()) == getFalse_3()){
        	System.out.println("if condition is false");
        }
        System.out.println("------------------------------------------");
        
        if (false || (dd=getTrue_2()) == getTrue_1() && (cc=getFalse_2()) == getFalse_3()){
        	System.out.println("if condition is true");
        }
        System.out.println("------------------------------------------");
        System.out.println("dd = " + dd+"; cc = "+cc);

	}
}
