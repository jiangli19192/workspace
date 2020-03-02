package com.zjl.study.date;

import java.util.Date;

public class DateExercise {
	
	public static void main(String[] args) {
		getCurrentDate();
	}
	
	private static void getCurrentDate() {
		// 初始化Date对象
		Date date = new Date();
		// 使用toString()函数显示日期时间
		System.out.println(date.toString());
	}

}
