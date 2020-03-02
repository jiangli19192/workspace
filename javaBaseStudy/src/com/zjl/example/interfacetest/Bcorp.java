package com.zjl.example.interfacetest;

/**
 * 实现接口的B公司类
 * ClassName : Bcorp
 * @author 张江立
 * @date 2019年6月19日 上午10:41:03
 *
 */
public class Bcorp implements Advertisement {

	@Override
	public void showAdvertisement() {
		System.out.println("BBBBBBBBBBBBBBBBB");
	}

	@Override
	public String getCorpName() {
		return "B Corp";
	}
}
