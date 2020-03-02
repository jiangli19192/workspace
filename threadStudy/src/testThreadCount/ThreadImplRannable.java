package testThreadCount;

public class ThreadImplRannable implements Runnable {
	private String threadName;
	
	public ThreadImplRannable(String threadName) {
		this.threadName = threadName;
	}

	@Override
	public void run() {
		
		System.out.println(threadName + "------线程执行完了存储过程程序!");
		
		TestThreadObject.INC();
		
		//TestThreadObject.count++; 
		System.out.println(threadName + "运行了1次");
		
		int count = TestThreadObject.getCount();
		if (count >= 5) {
			System.out.println("所有线程的执行结果合并");
		}
	}
}
