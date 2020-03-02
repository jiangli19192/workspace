package com.zjl.example.interfacetest;

/**
 * 实现接口的A公司类
 * ClassName : Acorp
 * @author 张江立
 * @date 2019年6月19日 上午10:41:14
 *
 */
public class Acorp implements Advertisement {

	@Override
	public void showAdvertisement() {
		System.out.println("AAAAAAAAAAAAAAAAA");
	}

	@Override
	public String getCorpName() {
		return "A Corp";
	}
}
