package com.zjl.study.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * 理论准备

        Map是键值对的集合接口，它的实现类主要包括：HashMap,TreeMap,Hashtable以及LinkedHashMap等。

        TreeMap：基于红黑树（Red-Black tree）的 NavigableMap 实现，该映射根据其键的自然顺序进行排序，或者根据创建映射时提供的 Comparator 进行排序，具体取决于使用的构造方法。

        HashMap的值是没有顺序的，它是按照key的HashCode来实现的，对于这个无序的HashMap我们要怎么来实现排序呢？参照TreeMap的value排序。

        Map.Entry返回Collections视图。
 * 
 * 
 * @author TEANA E-mail: mmz06@163.com
 * @version 创建时间：2011-1-21 下午02:23:07
 * @DO LinkedHashMap与HashMap
 */
public class LinkedMap {

	public static void orderMap() {
		// LinkedHashMap 有序
		Map<String, String> maps = new LinkedHashMap<String, String>();
		maps.put("1", "张三");
		maps.put("2", "李四");
		maps.put("3", "王五");
		maps.put("4", "赵六");
		
		System.out.println("LinkedHashMap(有序):");
		Iterator<Entry<String, String>> it = maps.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entity = (Entry<String, String>) it.next();
			System.out.println("[ key = " + entity.getKey() + ", value = "
					+ entity.getValue() + " ]");
		}
	}

	public static void unorderedMap() {
		// HashMap 无序
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "张三");
		map.put("2", "李四");
		map.put("3", "王五");
		map.put("4", "赵六");
		
		System.out.println("HashMap(无序):");
		Iterator<Entry<String, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entity = (Entry<String, String>) it.next();
			System.out.println("[ key = " + entity.getKey() + ", value = "
					+ entity.getValue() + " ]");
		}
	}

	public static void main(String[] args) {
//		orderMap();
//		unorderedMap();
//		mapKeyOrder();
//		mapValueOrder();
		testMap();
	}
	
	public static void testMap() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "A");
        map.put("b", "B");
        String val = map.compute("b", (k, v) -> "v"); // 输出 v
        System.out.println(val);
        String v1 = map.compute("c", (k, v) -> "v"); // 输出 v
        System.out.println(v1);
        
        Iterator<Entry<String, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entity = (Entry<String, String>) it.next();
			System.out.println("[ key = " + entity.getKey() + ", value = "
					+ entity.getValue() + " ]");
		}
    }
	
	
	/**
	 * TreeMap默认是升序的，如果我们需要改变排序方式，则需要使用比较器：Comparator。
	 * Comparator可以对集合对象或者数组进行排序的比较器接口，
	 * 实现该接口的public compare(T o1,To2)方法即可实现排序
	 */
	public static void mapKeyOrder(){
		Map<Integer, String> maps = new TreeMap<Integer, String>(new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
			
		});
		maps.put(0, "10");
		maps.put(4, "8");
		maps.put(8, "23");
		maps.put(12, "16");
		maps.put(10, "20");
		
		System.out.println("按TreeMap的Key进行排序:");
		Iterator<Entry<Integer, String>> it = maps.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, String> entity = (Entry<Integer, String>) it.next();
			System.out.println("[ key = " + entity.getKey() + ", value = "
					+ entity.getValue() + " ]");
		}
	}
	
	
	/**
	 * 上面例子是对根据TreeMap的key值来进行排序的，但是有时我们需要根据TreeMap的value来进行排序。
	 * 对value排序我们就需要借助于Collections的sort(List<T> list, Comparator<? super T> c)方法，
	 * 该方法根据指定比较器产生的顺序对指定列表进行排序。
	 * 但是有一个前提条件，那就是所有的元素都必须能够根据所提供的比较器来进行比较
	 */
	public static void mapValueOrder(){
		Map<Integer, String> maps = new TreeMap<Integer, String>();
		maps.put(0, "10");
		maps.put(4, "8");
		maps.put(8, "23");
		maps.put(12, "16");
		maps.put(10, "20");
		
		//这里将map.entrySet()转换成list
		List<Map.Entry<Integer,String>> list = new ArrayList<Map.Entry<Integer,String>>(maps.entrySet());
		
		//然后通过比较器来实现排序
		Collections.sort(list, new Comparator<Map.Entry<Integer,String>>() {
            //升序排序
            public int compare(Entry<Integer, String> o1,
                    Entry<Integer, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
            
        });
		
		System.out.println("按TreeMap的Value进行排序:");
		for(Map.Entry<Integer,String> entity : list){ 
            System.out.println("[ key = " + entity.getKey() + ", value = " + entity.getValue() + " ]"); 
       }
	}
}
