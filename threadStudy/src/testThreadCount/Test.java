package testThreadCount;

public class Test {
	public static void main(String[] args) {

		ThreadImplRannable t1 = new ThreadImplRannable("t1");
		ThreadImplRannable t2 = new ThreadImplRannable("t2");
		ThreadImplRannable t3 = new ThreadImplRannable("t3");
		ThreadImplRannable t4 = new ThreadImplRannable("t4");
		ThreadImplRannable t5 = new ThreadImplRannable("t5");

		new Thread(t1).start();
		new Thread(t2).start();
		new Thread(t3).start();
		new Thread(t4).start();
		new Thread(t5).start();
	}
}
