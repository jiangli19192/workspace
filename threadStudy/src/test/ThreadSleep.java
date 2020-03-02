package test;

public class ThreadSleep {
	public static void main(String[] args) {

		try {

			System.out.println("程序要暂停了！");

			long a=System.currentTimeMillis();
			// 关键代码
			Thread.sleep(10000);

			System.out.println("\r<br>执行耗时 : "+(System.currentTimeMillis()-a)/1000f+" 秒 ");
			System.out.println("-------程序再次启动！");

		} catch (InterruptedException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
	}
}
