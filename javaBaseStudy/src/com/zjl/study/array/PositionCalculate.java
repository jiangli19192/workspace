package com.zjl.study.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入非连续数字的数组，返回从断续数字分隔开的断续数组
 * ClassName : PositionCalculate
 * @author 张江立
 * @date 2018年11月2日 下午5:45:49
 *
 */
public class PositionCalculate {

	public static List<List<Integer>> splitAvailablePosition(
			List<Integer> availablePosition) {
		List<List<Integer>> availableSpace = new ArrayList<>();
		if (availablePosition.isEmpty()) {
			return availableSpace;
		}

		List<Integer> space = new ArrayList(Arrays.asList(availablePosition
				.get(0)));
		for (int i = 1; i < availablePosition.size(); i++) {
			if (availablePosition.get(i) - availablePosition.get(i - 1) > 1) {
				availableSpace.add(space);
				space = new ArrayList(Arrays.asList(availablePosition.get(i)));
			} else {
				space.add(availablePosition.get(i));
			}
		}
		availableSpace.add(space);
		return availableSpace;
	}

	public static void main(String[] args) {
		List<Integer> space = new ArrayList(Arrays.asList(2, 5, 6, 7, 8, 9, 10));
		System.out.println(splitAvailablePosition(space));

		List<Integer> space_2 = new ArrayList(Arrays.asList(2, 3, 4, 5, 6, 7,
				8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23,
				24));
		System.out.println(splitAvailablePosition(space_2));
	}
}
