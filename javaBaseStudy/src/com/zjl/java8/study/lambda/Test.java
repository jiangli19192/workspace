package com.zjl.java8.study.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.zjl.java8.study.entity.Option;

public class Test {

	public static void main(String[] args) {
		Test t = new Test();
//		t.testOne();
//		t.testTwo();
//		t.testThree();
		t.testFour();
	}

	private void testFour() {
		Map<String, Option> map = new HashMap<>();
		map.put("1", new Option());
		map.put("2", new Option());
		map.put("3", new Option());
		map.put("4", new Option());

		List<Option> emptyOptionsForOld = getContainShowPriceResultOptions_old(new HashMap<>(), true);
		emptyOptionsForOld.forEach(System.out::println);

		List<Option> optionsForOld = getContainShowPriceResultOptions_old(map, true);
		optionsForOld.forEach(System.out::println);

		System.out.println("----------------------------------");

		List<Option> emptyOptions = getContainShowPriceResultOptions(new HashMap<>(), true);
		emptyOptions.forEach(System.out::println);

		List<Option> options = getContainShowPriceResultOptions(map, true);
		options.forEach(System.out::println);
	}

	private void testThree() {
		Set<String> set = new HashSet<String>(){{add("1"); add("2");}};
		Optional<String> str = set.stream().findFirst();
		System.out.println(str.get());
	}

	private void testTwo() {
		MathOperator<Integer> m = (Integer x, Integer y) -> {return (x + y);};
		MathOperator<Integer> m2 = (Integer x, Integer y) -> x + y;
		System.out.println(m.operator(3, 3));
		System.out.println(m2.operator(new Integer(2), new Integer(3)));
	}

	private void testOne() {
		Hunman h = str -> System.out.println(str);
		h.say("Hello World");
	}

	private List<Option> getContainShowPriceResultOptions_old(Map<String, Option> map, boolean isShowPrice) {
        if (Objects.isNull(map) || map.isEmpty()) {
        	System.out.println("old method, map is empty!");
            return Collections.emptyList();
        }

        List<Option> result = new ArrayList<>();
        for (Map.Entry<String, Option> en : map.entrySet()) {
            Option option = (Option) en.getValue();
            option.setShowPrice(isShowPrice);
            result.add(option);
        }
        return result;
    }

    private List<Option> getContainShowPriceResultOptions(Map<String, Option> map, boolean isShowPrice) {
        if (Objects.isNull(map) || map.isEmpty()) {
        	System.out.println("map is empty!");
            return Collections.emptyList();
        }

        return map.entrySet().stream()
            .map(entry -> entry.getValue())
            .filter(Objects::nonNull)
            .peek(option -> option.setShowPrice(isShowPrice))
            .collect(Collectors.toList());
    }
}