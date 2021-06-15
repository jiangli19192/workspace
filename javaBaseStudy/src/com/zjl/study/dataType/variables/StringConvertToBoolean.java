package com.zjl.study.dataType.variables;

/**
 * Boolean值的字符串，转换成Boolean类型的数据
 */
public class StringConvertToBoolean {

    public static void main(String[] args) {
        convertStringToBoolean();
        convertBooleanToUpperCaseString();
    }

    private static boolean convertStringToBoolean() {
//        String source = "TRUE";
        String source = "true";
        boolean target = Boolean.valueOf(source);
        System.out.println("TRUE" + ", 转换后的结果是:" + target);

//        String source_2 = "FALSE";
        String source_2 = "false";
        boolean target_2 = Boolean.valueOf(source_2);
        System.out.println("FALSE" + ", the result of the transformation is:" + target_2);

        String source_3 = "";
        boolean target_3 = Boolean.valueOf(source_3);
        System.out.println("空字符串" + ", the result of the transformation is:" + target_3);

        String source_4 = " true";
        boolean target_4 = Boolean.valueOf(source_4.trim());
        System.out.println("空格true" + ", the result of the transformation is:" + target_4);

        String source_5 = "True";
        boolean target_5 = Boolean.valueOf(source_5.trim());
        System.out.println("空格True" + ", the result of the transformation is:" + target_5);


        return target;
    }

    private static String convertBooleanToUpperCaseString() {
        String source = "TRUE";
//        boolean source = true;
        String target = String.valueOf(source).toUpperCase();
        System.out.println("true" + ", 转换后的结果是:" + target);

        String source_2 = "FALSE";
//        boolean source_2 = true;
        String target_2 = String.valueOf(source_2).toUpperCase();
        System.out.println("true" + ", 转换后的结果是:" + target_2);

        return target_2;
    }
}
