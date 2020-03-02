package test;


/**
 * 每隔3秒执行一次， 执行三次后停止
 * ClassName : Main
 * @author 张江立
 * @date 2016年7月16日 下午9:17:39
 *
 */
public class TimerTest3 {

	public static void test(int index) {
		System.out.println("test:" + index);
	}

	public static void run() throws InterruptedException {
		int index = 0;
		final int count = 3;
		do {
			index++;
			test(index);
			Thread.sleep(1 * 1000);
		} while (index < count);
	}

	public static void main(String[] args) {
		System.out.println("开始执行程序");
		try {
			
			run();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("结束执行程序");
	}
}