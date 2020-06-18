package com.zjl.study.set;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class ContainsAll_Example {
	
	@Test
	public void containsAllMethodTest() {
		Set<String> oldSet = new HashSet<String>();
		oldSet.add("1");
		oldSet.add("2");
		oldSet.add("3");
		
		Set<String> newSet = new HashSet<String>();
		newSet.add("1");
		newSet.add("2");
		newSet.add("3");
		
		Assert.assertSame(oldSet.size(), newSet.size());
		Assert.assertTrue(oldSet.containsAll(newSet));
	}
}
