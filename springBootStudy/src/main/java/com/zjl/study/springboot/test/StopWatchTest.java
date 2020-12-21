package com.zjl.study.springboot.test;

import org.springframework.util.StopWatch;

public class StopWatchTest {
	public static void main(String[] args) {
		String id = "ABCD";
		String taskName1 = "Task Name 1";
		String taskName2 = "Task Name 2";
		
		
		StopWatch stopWatch = new StopWatch(id);
		
        stopWatch.start(taskName1);
        try {
			Thread.sleep(1000);
			System.out.println("暂停一秒打印：aaaaaaaaaaaaaaaa");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        stopWatch.stop();
//        System.out.println(stopWatch.toString());
        stopWatch.start(taskName2);
        try {
			Thread.sleep(2000);
			System.out.println("暂停两秒打印：bbbbbbbbbbb");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        stopWatch.stop();
        
        System.out.println(stopWatch.prettyPrint());
        System.out.println("任务个数：" + stopWatch.getTaskCount());
        System.out.println("所任务执行完成消耗总毫秒数:" + stopWatch.getTotalTimeMillis());
        System.out.println("所任务执行完成消耗总秒数:" + stopWatch.getTotalTimeSeconds());
	}
}
