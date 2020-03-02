package com.zjl.study.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class StringCharArrangeTest_2 {

    public void test3() {


        String input="abc";
        //1.开始排列
        List<String> sortResult = sort(input);
        System.out.println("排列组合,字符串:"+input);
        //2.消除重复列
        HashSet h = new HashSet(sortResult);
        sortResult.clear();
        sortResult.addAll(h);
        //3.打印输出
        sortResult.forEach(e -> System.out.println(e));
        //4.打印个数
        System.out.println("排列组合个数：" + sortResult.size());

    }

    private List<String> sort(String input) {
        List<String> sortList = new ArrayList();
        if (input == null || "".equals(input)) {
            System.out.println("提示：您输入了空字符,请输入有效值！");
            return new ArrayList();
        }
        char leftChar = input.charAt(0);
        if (input.length() > 1) {
            String rightString = input.substring(1, input.length());
            List<String> rightStringSortedList = sort(rightString);
            rightStringSortedList.forEach((e) -> {
                for (int i = 0; i < e.length() + 1; i++) {
                    sortList.add(new StringBuffer(e).insert(i, leftChar).toString());
                }
            });
        } else {
            sortList.add(String.valueOf(leftChar));
        }
        return sortList;
    }
}