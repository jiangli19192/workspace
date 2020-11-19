package com.zjl.study.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.crypto.spec.PSource;

public class SplitAvailablePosition {

	public static void main(String[] args) {
		testSplitAvailablePosition();
	}
	
	public static void testSplitAvailablePosition() {
		SplitAvailablePosition position = new SplitAvailablePosition();
		
		Integer[] integerArray = new Integer[]{1, 2, 3, 4, 5, 8, 9, 10};
		List<Integer> availablePosition = Arrays.asList(integerArray);
		
		List<List<Integer>> list = position.splitAvailablePosition(availablePosition);
		for (List<Integer> each : list) {
			System.out.println(each.toString());
		}
		
		Integer[] occupiedSpaceArray = new Integer[]{8, 9};
		List<Integer> occupiedSpace = Arrays.asList(occupiedSpaceArray);
		System.out.println(position.hasSpaceAvaliablePosition(list, occupiedSpace));
		
	}
	
    public List<List<Integer>> splitAvailablePosition(List<Integer> availablePosition) {
        List<List<Integer>> availableSpace = new ArrayList<>();
        if (availablePosition.isEmpty()) {
            return availableSpace;
        }
        List<Integer> space = new ArrayList<Integer>(availablePosition.get(0));
        for (int i = 1; i < availablePosition.size(); i++) {
        	// 两个位置之间不是连续的情况，保存前一段连续数据，重新开始新的一段统计
            if (availablePosition.get(i) - availablePosition.get(i - 1) > 1) {
                availableSpace.add(space);
                space = new ArrayList<Integer>();
                space.add(availablePosition.get(i));
            } else {
            	// 如果两个相临的位置是连接的，统计到当前集合内
                space.add(availablePosition.get(i));
            }
        }
        availableSpace.add(space);
        return availableSpace;
    }
    
    
    public boolean hasSpaceAvaliablePosition(List<List<Integer>> availableSpace, List<Integer> rackItemOccupiedSpace) {
        for (List<Integer> subAvailableSpace : availableSpace) {
            if (subAvailableSpace.containsAll(rackItemOccupiedSpace)) {
                return true;
            }
        }

        return false;
    }
}
