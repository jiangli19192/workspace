package example;

/**
 * 扩展Thread类实现的多线程例子
 * @author 张江立
 * @date 2016-3-5 22:15
 */
public class TestThread extends Thread{
	public TestThread(String name){
		super(name);
	}

	@Override
	public void run() {
		for(int i = 0; i < 5; i++){
			for(long k = 0; k < 100000000; k++){
				//System.out.println(name + ":" + k + "次,  " + i);
				if (k == 0) {
					System.out.println(this.getName() + ":" + "第一次,  " + i);
				} else if (k == (100000000 - 1)) {
					System.out.println(this.getName() + ":" + "最后一次,  " + i);
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		Thread t1 = new TestThread("阿三"); 
        Thread t2 = new TestThread("李四"); 
        
        // 启动线程
        t1.start(); 
        t2.start();
	}
}
