package com.zjl.java8.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lianxu {  
  
    public static void main(String[] args) {  
        int[] arr = new int[] { 1, 2, 5, 6, 8, 8,8,8,8,9, 9, 3, 9,3,4,4 };  
        int[] arr1 = new int[] { 1, 2, 3, 4, 5, 6, 1, 9 };  
        int[] arr2 = new int[] { 2, 3, 9 }; 
        int[] arr3 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8};
        int[] arr4 = new int[] { 4, 5, 6, 7, 8};
        int[] arr5 = new int[] { 4, 5};
        int[] arr6 = new int[] { 4};
        int[] arr7 = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48};
        
        //System.out.println(IsSeries(arr, 1, 10).toString());  
//      System.out.println(IsSeries(arr1, 1, 15).toString());  
//      System.out.println(IsRepeat(arr).toString());  
//        System.out.println(IsSeries(arr2, 2, 15).toString());  
        
        
//        System.out.println(isSeriesArray(arr));
//        System.out.println(isSeriesArray(arr1));
//        System.out.println(isSeriesArray(arr2));
//        System.out.println(isSeriesArray(arr3));
//        System.out.println(isSeriesArray(arr4));
//        System.out.println(isSeriesArray(arr5));
//        System.out.println(isSeriesArray(arr6));
        
        
        List<String> list = new ArrayList<String>(Arrays.asList("4", "6", "8", "7", "5"));
        
        
//        System.out.println(isSeriesArray(arr4));
//        System.out.println(isSeriesArray2(arr5));
//        System.out.println(isSeriesArray2(arr6));
        System.out.println(isSeriesArray2(arr7));
  
    }

    /**
     * 判断int数组内的数据，是连续的整数
     * @param a
     * @return
     */
    public static boolean isSeriesArray(int[] a) {
        Arrays.sort(a);
        return a[a.length-1] - a[0] == a.length - 1 ? true : false;
   }
    
    public static boolean isSeriesArray2(int[] a) {
    	if (a.length < 3) {
    		return false;
    	}
    	Arrays.sort(a);
    	return a[a.length-1] - a[0] == a.length - 1 ? true : false;
    }
      
      
    /** 
     * 获取一个数组里面的重复的项 
     * @param num 
     * @return 
     */  
    private static List<Integer> IsRepeat(int[] num) {  
  
        List<Integer> r = new ArrayList<Integer>();  
        // 循环数组中所有的数据  
        for (int i = 0; i < num.length; i++) {  
            if (i < num.length - 1) {  
                if (num[i] == num[i + 1]) {  
                    // 当数据处于循环再开始时  
                    r.add(num[i]);  
                }  
  
            }  
        }  
        return r;  
  
    }  
  
    /** 
     * 获取一个数组中部连续的项 
     * @param num 目标数组 
     * @param start 数组的开始项 
     * @param end 数组的结束项 
     * @return 
     */  
    private static List<Integer> IsSeries(int[] num, int start, int end) {  
  
        List<Integer> r = new ArrayList<Integer>();  
        // 循环数组中所有的数据  
        for (int i = 0; i < num.length; i++) {  
            // 判断是不是到了数组末尾  
            if (i < num.length - 1) {  
                // 排除重复数据的情况  
                // 当数据不连续的时候  
                if (num[i] + 1 != num[i + 1]) {  
                    // 当数据处于循环再开始时  
                    if (num[i + 1] - num[i] < 0) {  
                        // 判断最后的数字是不是最大的开始数字start  
                        int cha = end - num[i];  
                        for (int j = 1; j <= cha; j++) {  
                            r.add(num[i] + 1 * j);  
                        }  
                        // 判断刚开始的数字是不是end  
                        int cha1 = num[i + 1] - start;  
                        for (int j = 0; j < cha1; j++) {  
                            r.add(start + 1 * j);  
                        }  
                    } else {  
                        // 处理既不连续又不是开头和结尾的情况  
                        int cha = num[i + 1] - num[i];  
                        for (int j = 1; j < cha; j++) {  
                            r.add(num[i] + 1 * j);  
                        }  
                    }  
  
                }  
  
            }  
        }  
        return r;  
  
    }  
}  