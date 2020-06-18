package com.zjl.java8.study.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;




import org.junit.Assert;
import org.junit.Test;

public class EmptyStream_Example {
	
	@Test
	public void emptyStreamOutTest() {
		List<String> list = new ArrayList<>();
		List<String> newList = list.stream().collect(Collectors.toList());
		
		Assert.assertTrue(Objects.nonNull(newList));
		Assert.assertEquals(0, newList.size());
	}

}
