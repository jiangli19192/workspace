package com.zjl.java8.study.iteration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

/**
 * https://blog.csdn.net/czydream/article/details/81585069
 * ClassName : PredicatTest
 * @author 张江立
 * @date 2018年12月12日 下午6:32:20
 *
 */
public class PredicatTest {
	public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("水煮鱼");
        list.add("酸菜鱼");
        list.add("麻辣鱼");
        list.add("麻婆豆腐");
        list.add("回锅肉");
        list.add("鱼香肉丝");
        list.add("水煮肉片");
        list.add("宫保鸡丁");
        list.add("剁椒鱼头");
        list.add("夫妻肺片");
        //统计list中名字只有三个字符的菜品
        int count1 = getCount(list, obj -> ((String) obj).length() == 3);
        System.out.println("菜名只有三个字的菜品有" + count1 + "个");
        //统计list中关于鱼的菜品有几个
        int count2 = getCount(list, obj -> ((String) obj).contains("鱼"));
        System.out.println("list中关于鱼的菜品有" + count2 + "个");
    }

    public static int getCount(Collection collection, Predicate predicate) {
        int count = 0;
        for (Object o : collection) {
            if (predicate.test(o)) {
                count++;
            }
        }
        return count;
    }
}
