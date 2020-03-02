package com.zjl.study.variables;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Double对象转换成百分比形式
 * ClassName : DoubleConvertToPercent
 * @author 张江立
 * @date 2019年10月30日 下午2:34:24
 *
 */
public class DoubleConvertToPercent {
	
	public static void main(String[] args) {
		Double rate =0.0302;
		NumberFormat num = NumberFormat.getPercentInstance(); 
		String rates = num.format(rate);
		
		System.out.println(rates);
		
		
		double result1=0.51111122111111;
		DecimalFormat df = new DecimalFormat("0.00%");
		String r = df.format(result1);
		System.out.println(r);//great
		
		System.out.println();
		
		
		Double evaluation = 0.0302;
		NumberFormat numberFormat = NumberFormat.getPercentInstance();
		numberFormat.setMaximumIntegerDigits(3);
		numberFormat.setMaximumFractionDigits(2);
		System.out.println(numberFormat.format(evaluation));
	}
}
