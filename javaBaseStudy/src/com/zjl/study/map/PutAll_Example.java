package com.zjl.study.map;

import java.util.HashMap;
import java.util.Map;



import org.junit.Assert;
import org.junit.Test;

public class PutAll_Example {

	@Test
	public void mapPutAllMethodTest() {
		Map<String, String> map = new HashMap<>();
		map.put("a", "a");
		map.put("b", "a");
		map.put("c", "a");
		
		Map<String, String> map_2 = new HashMap<>();
		map_2.put("b", "b");
		map_2.put("c", "c");
		
		map.putAll(map_2);
		
		Assert.assertEquals(3, map.size());
		Assert.assertEquals(map.get("a"), "a");
		Assert.assertEquals(map.get("b"), "b");
		Assert.assertEquals(map.get("c"), "c");
	}
	
	@Test
	public void mapPutAllMethodTest_2() {
		Map<String, String> map = new HashMap<>();
		map.put("a", "a");
		map.put("b", "a");
		map.put("c", "a");
		
		Map<String, String> map_2 = new HashMap<>();
		map_2.put("b", "b");
		map_2.put("c", "c");
		
		map_2.putAll(map);
		
		Assert.assertEquals(3, map.size());
		Assert.assertEquals(map.get("a"), "a");
		Assert.assertEquals(map.get("b"), "a");
		Assert.assertEquals(map.get("c"), "a");
	}
}
