package com.zjl.jvm.classLoader;

/**
 * 双亲委派机制验证
 * Parental delegation mechanism
 * 
 * 当一个类加载器收到了类加载请求，他首先不会尝试自己去加载这个类，
 * 而是把这个请求委派给父类去完成，每一个层次类加载器都是如此，
 * 因此所有的加载请求，都应该传送到启动类加载器中，
 * 只有当父类加载器反馈自己无法完成这个请求的时候（在它的加载路径下没有找到所需加载的Class），
 * 子类加载器才会尝试自己去加载。
 * 
 * ClassName : String
 * @author 张江立
 * @date 2020年3月1日 下午10:39:05
 *
 */
/*public class String {
	*//**
	 * 此String类，首先在启动加载器地址内查找，找到了此类，但是此类内没有定义main方法
	 * 这是因为在同一个包下重复定义类造成
	 * @param args
	 *//*
	public static void main(String[] args) {
	}
}*/
