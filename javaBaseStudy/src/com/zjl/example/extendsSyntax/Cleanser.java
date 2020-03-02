package com.zjl.example.extendsSyntax;

/**
 * cleanser 清洁工
 * ClassName : Cleanser
 * @author 张江立
 * @date 2017年11月2日 下午2:34:31
 *
 */
public class Cleanser {
	private String s = "Cleanser";
	
	public void append(String a) { 
		s += a;
	}
	
	/**
	 * 稀释
	 */
	public void dilute() {
		append(" dilute()");
	}
	
	/**
	 * 涂摸
	 */
	public void apply() {
		append(" apply()");
	}
	
	/**
	 * 擦洗者
	 */
	public void scrub() {
		append(" scrub()");
	}
	
	public String toString() {
		return s;
	}
	
	public static void main(String[] args) {
		Cleanser cleanser = new Cleanser();
		cleanser.dilute();
		cleanser.apply();
		cleanser.scrub();
		System.out.println(cleanser);
	}
}
