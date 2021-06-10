package testThreadCount;

public class Test {
	public static void main(String[] args) {

		ThreadImplRunnable t1 = new ThreadImplRunnable("t1");
		ThreadImplRunnable t2 = new ThreadImplRunnable("t2");
		ThreadImplRunnable t3 = new ThreadImplRunnable("t3");
		ThreadImplRunnable t4 = new ThreadImplRunnable("t4");
		ThreadImplRunnable t5 = new ThreadImplRunnable("t5");

		new Thread(t1).start();
		new Thread(t2).start();
		new Thread(t3).start();
		new Thread(t4).start();
		new Thread(t5).start();
	}
}
