package example;

/**
 * ʵ��Runnable�ӿڵĶ��߳�����
 * ʵ��Runnable�ӿڵ���
 * @author �Ž���
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
				//System.out.println(name + ":" + k + "��,  " + i);
				if (k == 0) {
					System.out.println(name + ":" + "��һ��,  " + i);
				} else if (k == (100000000 - 1)) {
					System.out.println(name + ":" + "���һ��,  " + i);
				}
			}
		}
	}

}
