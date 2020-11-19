package com.zjl.study.date;

/**
 * Java计算程序代码执行时间的方法 ClassName : MethodTakeTimeTest
 * 
 * 有时候为了排查性能问题，需要记录完成某个操作需要的时间， 我们可以使用System类的currentTimeMillis()方法来返回当前的毫秒数，
 * 并保存到一个变量中，在方法执行完毕后再次调用 System的currentTimeMillis()方法，
 * 并计算两次调用之间的差值，就是方法执行所消耗的毫秒数。
 * 
 * @author 张江立
 * @date 2020年7月9日 下午2:12:59
 *
 */
public class MethodTakeTimeTest {

	public static void main(String[] args) {
		MethodTakeTimeTest test = new MethodTakeTimeTest();
		// test.test();
		test.test_2();
	}

	public void test() {
		long startTime = System.currentTimeMillis(); // 获取开始时间
		doSomething(); // 测试的代码段
		long endTime = System.currentTimeMillis(); // 获取结束时间
		System.out.println("程序运行时间：" + (endTime - startTime) + "ms"); // 输出程序运行时间
	}

	/**
	 * 以纳秒为单位计算的(使用System的nanoTime()方法)
	 */
	public void test_2() {
		long startTime = System.nanoTime(); // 获取开始时间
//		doSomething();
		computeAndDisplayElapsedTime(); // 测试的代码段
		long endTime = System.nanoTime(); // 获取结束时间
		System.out.println("程序运行时间： " + (endTime - startTime) + "ns");
	}

	public void doSomething() {
		String str = "";
		long starTime = System.currentTimeMillis();
		// 计算循环10000的时间
		for (int i = 0; i < 10000; i++) {
			str = str + i;
		}
		long endTime = System.currentTimeMillis();
		long Time = endTime - starTime;
		System.out.println("doSomething 1: " + Time);

		StringBuilder bulider = new StringBuilder("");
		starTime = System.currentTimeMillis();
		for (int j = 0; j < 10000; j++) {
			bulider.append(j);
		}
		endTime = System.currentTimeMillis();
		Time = endTime - starTime;
		System.out.println("doSomething 2: " + Time);
	}

	/**
	 * 计算两个时间点直接逝去的毫秒数
	 *
	 */
	public void computeAndDisplayElapsedTime() {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(60);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		long endTime = System.currentTimeMillis();
		float seconds = (endTime - startTime) / 1000F;
		System.out.println(Float.toString(seconds) + " seconds.");
	}
}
