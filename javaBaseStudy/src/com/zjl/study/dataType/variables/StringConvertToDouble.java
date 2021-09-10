package com.zjl.study.dataType.variables;

public class StringConvertToDouble {

    public static void main(String[] args) {
        System.out.println(Double.valueOf("0"));
        System.out.println(Double.valueOf("10"));
        System.out.println(Double.valueOf("10.12"));
        // Exception in thread "main" java.lang.NumberFormatException: empty String
//        System.out.println(Double.valueOf(""));
        // Exception in thread "main" java.lang.NumberFormatException: For input string: "null"
//        System.out.println(Double.valueOf("null"));
        // Exception in thread "main" java.lang.NullPointerException
//        System.out.println(Double.valueOf(null));

    }
}
