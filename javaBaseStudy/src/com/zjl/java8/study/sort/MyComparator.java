package com.zjl.java8.study.sort;

import java.util.Comparator;

class MyComparator implements Comparator<Sort> {

	@Override
	public int compare(Sort o1, Sort o2) {
		if (o1.getOne() > o2.getOne()) {
            return 1;
        } else if (o1.getOne() < o2.getOne()) {
            return -1;
        } else {
            return -1;
        }
	}
	
}