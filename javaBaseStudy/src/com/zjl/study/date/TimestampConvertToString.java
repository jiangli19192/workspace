package com.zjl.study.date;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TimestampConvertToString {
	
	private static String timestampToString(String formatStr) {
		Timestamp ts = new Timestamp(System.currentTimeMillis());   
        String tsStr = "";   
        DateFormat sdf = new SimpleDateFormat(formatStr);   
        try {   
            //方法一   
            tsStr = sdf.format(ts);   
//            System.out.println(tsStr);   
            //方法二   
//            tsStr = ts.toString();   
//            System.out.println(tsStr);   
        } catch (Exception e) {   
            e.printStackTrace();   
        } 
        
        return tsStr;
	}
	
	private static String timestampToString2(String formatStr) {
		Timestamp ts = new Timestamp(System.currentTimeMillis());   
        String tsStr = ts.toString();
        return tsStr;
	}

	public static void main(String[] args) {
		String formatStr = "yyyy/MM/dd HH:mm:ss";
		System.out.println(TimestampConvertToString.timestampToString(formatStr));
		formatStr = "dd/MM/yyyy";
		System.out.println(TimestampConvertToString.timestampToString(formatStr));
	}

}
