package testThreadCount;

public class TestThreadObject {
	static int count = 0;
	
	public static synchronized void INC(){
			count = count + 1;
			System.out.println("count=" + count);
	}
	
	public static synchronized int getCount(){
		return count;
	}
}
