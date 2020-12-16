package com.zjl.study.string.splitTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.collect.Maps;

public class SplitTest {
	
	public static void main(String[] args) {
		SplitTest test = new SplitTest();
		
		String propertyVaue = "HPC and AI - Systems | HPC and AI - LESI Solution, HPCLESI";
		List<String> elements = test.getSplitByVerticalLine(propertyVaue);
		
		Map<String, List<String>> solutionMap = test.getSolutionMap(elements, "HPCLESI");
		
		System.out.println(solutionMap);
	}
	
	public Map<String, List<String>> getSolutionMap(List<String> elements, String slice) {
		Map<String, List<String>> solutionMap = Maps.newHashMap();
		
        elements.forEach(s -> {
            List<String> separated = getSplitByComma(s);
            String solutionValue = separated.remove(0);
            List<String> sliceValue = Arrays.asList(slice);
            if (!separated.isEmpty()) {
                sliceValue = separated;
            }
            solutionMap.put(solutionValue, sliceValue);
        });
        
        return solutionMap;
	}
	
	/**
	 * 通过逗号分隔字符串
	 * @param param
	 * @return
	 */
	public List<String> getSplitByComma(String param) {
		List<String> separated = Stream.of(param.split(",")).map(String::trim).collect(Collectors.toList());
		for (String str : separated) {
			System.out.println("getSplitByComma:\"" + param + "\":" + str);
		}
		
		
		return separated;
	}
	
	/**
	 * 通过竖线分隔字符串
	 * @param propertyVaue
	 * @return
	 */
	public List<String> getSplitByVerticalLine(String propertyVaue) {
		String[] strArray = propertyVaue.split("\\|");
		List<String> elements = Stream.of(strArray).collect(Collectors.toList());
		for (String str : elements) {
			System.out.println("getSplitByVerticalLine:\"" + propertyVaue + "\":" + str);
		}
		
		return elements;
	}
}
