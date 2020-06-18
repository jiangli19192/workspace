package com.zjl.thread.TreadLocal;


/**
 * ThreadLocal的简单入门使用
 * https://blog.csdn.net/qq_28702545/article/details/51661663
 * ThreadLocal并不是一个Thread，而是Thread的局部变量。
 * 
 * 首先创建一个ThreadLocal对象，并且通过泛型指定要在线程中存入的值。
 * 然后就是在不同的线程中set和get，通过结果可以看到，不同的线程获取的值是对应该线程设置的值
 * ClassName : TreadLocal_Example
 * @author 张江立
 * @date 2020年6月3日 下午3:16:52
 *
 */
public class TreadLocal_Example {
	public static final ThreadLocal<String> mThreadLocal = new ThreadLocal<String>();
	
	public static void main(String[] args) {
		// 主线程设置为小明
		mThreadLocal.set("小明");
		
		new Thread("thread--1") {
			public void run() {
				mThreadLocal.set("小红");
				System.out.println("thread--1:" + mThreadLocal.get());
			};
		}.start();
		
		
		new Thread("thread--2") {
			public void run() {
				mThreadLocal.set("小花");
				System.out.println("thread--2:" + mThreadLocal.get());
			};
		}.start();
		
		System.out.println("主线程:" + mThreadLocal.get());
	}

}
