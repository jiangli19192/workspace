package com.zjl.example.extendsSyntax;

/**
 * 清洁剂
 * ClassName : Detergent
 * @author 张江立
 * @date 2017年11月2日 下午2:41:54
 *
 */
public class Detergent extends Cleanser {
	
	// Change a method
	public void scrub() {
		append(" Detergent.scrub()");
		super.scrub(); // Call base-class version
	}
	
	// Add methods to the interface
	public void foam() {
		append(" foam()");
	}

	public static void main(String[] args) {
		Detergent detergent = new Detergent();
		detergent.dilute();
		detergent.apply();
		detergent.scrub();
		detergent.foam();
		System.out.println(detergent);
		System.out.println("Testing base class:");
		Cleanser.main(args);
	}

}
