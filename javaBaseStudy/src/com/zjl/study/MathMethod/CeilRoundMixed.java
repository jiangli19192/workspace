package com.zjl.study.MathMethod;

/**
 * Ceil和Round方法混合使用例子
 * ClassName : CeilRoundMixed
 * @author 张江立
 * @date 2020年2月21日 下午10:41:56
 *
 */
public class CeilRoundMixed {

	public static void main(String[] args) {
	    int i;
	    float f = 2.3f;
	    double d = 2.7;
	    i = ((int)Math.ceil(f)) * ((int)Math.round(d));

	    System.out.println(i);
	}

}
