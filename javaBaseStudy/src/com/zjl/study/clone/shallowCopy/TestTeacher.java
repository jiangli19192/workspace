package com.zjl.study.clone.shallowCopy;

/**
 * 对象中全部是基本类型
 * ClassName : Test
 * @author 张江立
 * @date 2019年6月14日 下午4:10:56
 *
 */
public class TestTeacher {
	public static void main(String[] args) {
		Teacher origin = new Teacher("tony", 11);
		System.out.println(origin.getName());
		
	    Teacher clone = (Teacher) origin.clone();
	    clone.setName("clone");
	    
	    System.out.println(origin.getName());
	    System.out.println(clone.getName());
	    // 从运行结果和图上可以知道，克隆后的值变量会开辟新的内存地址，克隆对象修改值不会影响原来对象。
	}
}
