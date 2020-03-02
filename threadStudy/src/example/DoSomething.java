package example;

/**
 * 实现Runnable接口的多线程例子
 * 实现Runnable接口的类
 * @author 张江立
 * @date 2016-3-5 22:15
 */
public class DoSomething implements Runnable {
	private String name;
	
	public DoSomething(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for(int i = 0; i < 5; i++){
			for(long k = 0; k < 100000000; k++){
				//System.out.println(name + ":" + k + "次,  " + i);
				if (k == 0) {
					System.out.println(name + ":" + "第一次,  " + i);
				} else if (k == (100000000 - 1)) {
					System.out.println(name + ":" + "最后一次,  " + i);
				}
			}
		}
	}

}
