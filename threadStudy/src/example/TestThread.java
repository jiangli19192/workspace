package example;

/**
 * ��չThread��ʵ�ֵĶ��߳�����
 * @author �Ž���
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
				//System.out.println(name + ":" + k + "��,  " + i);
				if (k == 0) {
					System.out.println(this.getName() + ":" + "��һ��,  " + i);
				} else if (k == (100000000 - 1)) {
					System.out.println(this.getName() + ":" + "���һ��,  " + i);
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		Thread t1 = new TestThread("����"); 
        Thread t2 = new TestThread("����"); 
        
        // �����߳�
        t1.start(); 
        t2.start();
	}
}
