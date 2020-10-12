//package com.zjl.study.map;
//import java.util.Collections;
//
//import com.google.common.collect.ArrayListMultimap;
//import com.google.common.collect.Multimap;
//
//
///** https://www.cnblogs.com/kaituorensheng/p/6918809.html
// * https://my.oschina.net/leejun2005/blog/179645?fromerr=3wB0Gbjo
// * {
//    "a": [
//        1,
//        2,
//        3
//    ],
//    "b": [
//        3,
//        7
//    ]
//}
// * ClassName : testMultimap
// * @author 张江立
// * @date 2020年9月27日 下午3:47:40
// *
// */
//public class testMultimap {
//    public static void main(String[] argv) {
//        Multimap<String, String> myMultiMap = ArrayListMultimap.create();
//        myMultiMap.put("Fruits", "Apple");
//        myMultiMap.put("Fruits", "Pear");
//        myMultiMap.put("Fruits", "Banana");
//        myMultiMap.put("Vegetables", "eggplant");
//
//        System.out.println("\nmyMultiMap size:" + myMultiMap.size());
//
//        System.out.println("\nmyMultiMap.get(Fruits): " + myMultiMap.get("Fruits"));
//        System.out.println("\nmyMultiMap.get(Vegetables): " + myMultiMap.get("Vegetables"));
//
//        System.out.println("\nkeys:");
//        for (String key : myMultiMap.keys()) {
//            System.out.println(key);
//        }
//
//        System.out.println("\nvalues:");
//        for (String value : myMultiMap.values()) {
//            System.out.println(value);
//        }
//
//        myMultiMap.remove("Fruits", "Apple");
//        System.out.println("\nmyMultiMap size:" + myMultiMap.size());
//
//        myMultiMap.removeAll("Fruits");
//        System.out.println("\nmyMultiMap size:" + myMultiMap.size());
//    }
//}