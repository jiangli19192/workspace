package com.zjl.study.MathMethod;

/**
 * 四舍五入取整
 * ClassName : RoundTest
 * @author 张江立
 * @date 2020年2月21日 下午10:34:47
 *
 */
public class RoundTest {

	public static void main(String[] args) {
		double a = 2.4;
		long result_a = Math.round(a);
		System.out.println("四舍五入取整, (long)result_a = " + result_a + "; (int)result_a = " + (int)result_a);
		
		double d = 2.7;
		long result = Math.round(d);
		System.out.println("四舍五入取整, (long)result = " + result + "; (int)result = " + (int)result);
	}
}
