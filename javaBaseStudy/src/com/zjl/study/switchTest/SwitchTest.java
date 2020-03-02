package com.zjl.study.switchTest;

public class SwitchTest {

	public static void main(String[] args) {
		switchMethod("lfo");
		System.out.println("-----------------cto--------------");
		switchMethod("cto");
		System.out.println("-----------------default--------------");
		switchMethod("");
	}

	static void switchMethod(String mode) {
		switch (mode) {
		case "lfo":
			System.out.println("lfo");
			break;
		case "cto":
		default:
			System.out.println("lfo");
			System.out.println("cto");
		}
	}
}
