package com.zjl.example.interfacetest;

/**
 * 测试类
 * 程序会根据对象的不同调用不同的方法。若想要添加C公司，只要实现接口的方法就可以了。
 * ClassName : Test
 * @author 张江立
 * @date 2019年6月19日 上午10:40:37
 *
 */
public class Test {
	public static void main(String[] args) {
		AdvertisementBoard board = new AdvertisementBoard();
		board.show(new Acorp());
		board.show(new Bcorp());
	}
}
