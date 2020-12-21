package com.zjl.study;

import com.google.common.base.Stopwatch;


public class StopWatchTest {
	public static void main(String[] args) {
		Stopwatch stopwatch = Stopwatch.createStarted();
		stopwatch.start();
		System.out.println("content");
		stopwatch.stop();
		System.out.println(stopwatch.toString());
	}
}
