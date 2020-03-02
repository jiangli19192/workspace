package com.zjl.java8.study.iteration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapComputeIfPresentTest {
	public static void main(String[] args) {
		Map<String, Integer> wordCounts = new ConcurrentHashMap<>(10);
        String s =
                "Lorem ipsum dolor sit amet consetetur iam nonumy sadipscing " +
                        " elitr, sed diam nonumy eirmod tempor invidunt ut erat sed " +
                        "labore et dolore magna dolor sit amet aliquyam erat sed diam";

        wordCounts.put("sed", 0);
        for (String t : s.split(" ")) {
            wordCounts.computeIfPresent(t, (k, v) -> v + 1);// 如果存在KEY = "sed", value + 1
            wordCounts.computeIfAbsent("Lorem", key -> 0);// 如果不存在KEY = "Lorem", value设置为0
        }
        System.out.println(wordCounts);
	}
}
