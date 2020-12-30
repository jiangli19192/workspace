package com.zjl.study.list;
import java.util.ArrayList;
import java.util.List;

/**
 * link url:https://blog.csdn.net/weixin_41848505/article/details/94380420
 * ClassName : ListDemo
 * @author 张江立
 * @date 2020年12月30日 下午2:36:38
 *
 */
public class ListSplitTest {
 
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        for (int i = 1; i <= 1988; i++) {
            list.add(i);
        }
        List<List<Integer>> result = splitList(list, 500);
        for (int i = 0; i < result.size(); i++) {
        	System.out.println(result.get(i));
        }
        System.out.println("分隔后List个数：\t" + result.size());
    }
 
    /**
     * 按指定大小，分隔集合，将集合按规定个数分为n个部分
     *
     * @param list
     * @param len
     * @return
     */
    public static <T> List<List<T>> splitList(List<T> list, int len) {
        if (list == null || list.size() == 0 || len < 1) {
            return null;
        }
        //返回结果
        List<List<T>> result = new ArrayList<List<T>>();
        //传入集合长度
        int size = list.size();
        //分隔后的集合个数
        int count = (size + len - 1) / len;
        for (int i = 0; i < count; i++) {
            List<T> subList = list.subList(i * len, ((i + 1) * len > size ? size : len * (i + 1)));
            result.add(subList);
        }
        return result;
    }
}