package test;

/**
 * ������Դ��ַ��
 * http://blog.csdn.net/ghsau/article/details/7421217
 * 
 * http://lavasoft.blog.51cto.com/62575/99150
 * @author �Ž���
 *
 */
public class Count {

	public void count() {
		int num = 0;
		
		for (int i = 1; i <= 10; i++) {
			num += i;
		}
		System.out.println(Thread.currentThread().getName() + "-" + num);
	}
}