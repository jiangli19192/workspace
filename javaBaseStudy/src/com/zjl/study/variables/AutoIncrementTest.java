package com.zjl.study.variables;

/**
 * 前++和后++总结：其实大家只要记住一句话就可以了，前++是先自加再使用而后++是先使用再自加！ ClassName : Test
 * 
 * @author 张江立
 * @date 2019年2月14日 下午5:40:32
 *
 */
public class AutoIncrementTest {

	public static void main(String[] args) {
		AutoIncrementTest test = new AutoIncrementTest();
		test.outI();
		test.beforePlus();
	}

	public void outI() {
		int i = 0, k = 10;
		while (k-- > 0) {
			i = i++;
			System.out.println("i = " + i + "; k = " + k);
		}
	}

	public void beforePlus() {
		// 测试，前加加和后加加
		// 前++和后++总结：其实大家只要记住一句话就可以了，前++是先自加再使用而后++是先使用再自加！
		int age = 6;
		// 先自加，再使用(age先自加1，然后再打印age=7,此时age的值在内存中是7)
		System.out.println("1.age=" + ++age);
		// 先使用，再自加(此时age的值在内存中是7，先打印age=7,然后age再自加1，所以此时打印age=7,但是其实此时age的值在内存中已经是8了)
		System.out.println("2.age=" + age++);
		// 此时打印出来age=8
		System.out.println("3.age=" + age);
		// 先自加，再使用(此时age在内存中的值是8，先自加1，age的值在内存中就变成了9，然后再打印age，所以此时打印出9)
		System.out.println("4.age=" + ++age);
		// 先使用，再自加(此时age在内存中的值是9，先打印出9，然后age再自加1，自加完后，此时age在内存中的值是10)
		System.out.println("5.age=" + age++);
		// 此时打印age是10
		System.out.println("6.age=" + age);
		int index = 0;
		String[] names = { "令狐冲", "张无忌", "韦小宝", "杨过", "段誉", "乔峰" };
//		System.out.println(names[index++]); // 打印出令狐冲
//		System.out.println(names[index]); // 打印出张无忌
		System.out.println(names[++index]); // 打印出张无忌
		System.out.println(names[index]); // 打印出张无忌
	}
}
