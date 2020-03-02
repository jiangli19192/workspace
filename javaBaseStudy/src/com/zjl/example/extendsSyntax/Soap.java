package com.zjl.example.extendsSyntax;

/**
 * 肥皂
 * ClassName : Soap
 * @author 张江立
 * @date 2017年11月2日 下午3:09:46
 *
 */
public class Soap extends Cleanser {

	public static void main(String[] args) {
		Soap soap = new Soap();
		soap.dilute();
		soap.apply();
		soap.scrub();
		System.out.println(soap);
		System.out.println("Testing base class:");
	}

	/**
	 * 擦洗
	 */
	@Override
	public void scrub() {
		append("Soap.scrub()");
		super.scrub();
	}
	
	/**
	 * 消毒
	 */
	public void sterilize() {
		append("sterilize()");
	}

}
