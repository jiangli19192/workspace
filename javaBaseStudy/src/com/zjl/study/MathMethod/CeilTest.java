package com.zjl.study.MathMethod;

/**
 * 进一法取整
 * ClassName : CeilTest
 * @author 张江立
 * @date 2020年2月21日 下午10:28:58
 *
 */
public class CeilTest {
	public static void main(String[] args) {
		double a = Math.ceil(2.0d);
		System.out.println(a);
		
		double b = Math.ceil(2.1d);
		System.out.println("进一法取整, b = " + b);
		
		float f = 2.3f;
		double result = Math.ceil(f);
		System.out.println("进一法取整, (double)result = " + result + "; (int)result = " + (int)result);
		
		double d = 2.7d;
		double result_2 = Math.ceil(d);
		System.out.println("进一法取整, (double)result_2 = " + result_2 + "; (int)result_2 = " + (int)result_2);
	}
}
