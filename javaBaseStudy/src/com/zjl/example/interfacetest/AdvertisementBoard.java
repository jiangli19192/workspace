package com.zjl.example.interfacetest;

/**
 * source url: https://www.cnblogs.com/silence-hust/p/4147403.html
 * 
 * 设计AdvertisementBoard类（广告牌），该类有一个show（Advertisement adver）方法，
 * 该方法的参数是接口Advertisement的类型，显然该参数adver可以存放任何实现Advertisement接口的类的对象的引用，
 * 并回调类重写的接口方法showAdvertisement()来显示公司的广告词，回调类重写的接口方法getCorpName来获取公司名称。
 * ClassName : AdvertisementBoard
 * @author 张江立
 * @date 2019年6月19日 上午10:41:35
 *
 */
public class AdvertisementBoard {
	public void show(Advertisement adver) {
		System.out.println(adver.getCorpName()+"广告词");
		adver.showAdvertisement(); // 接口回调
	}
}
