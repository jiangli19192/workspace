package test;

public class ThreadTest {
	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				Count count = new Count();
				count.count();
			}
		};
		
		
		for(int i = 0; i < 10; i++){
			new Thread(runnable).start();
		}
	}
}
