package com.zjl.study.list;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		Vector<String> vec = new Vector<String>();

		Collections.sort(vec);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put(null, null);
		map.put(null, "1");
		map.put("1", null);
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("key=" + entry.getKey() + "; value=" + entry.getValue());
		}
	}

}
