package com.zjl.study.object;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EqualHashcodeTest {

	public static void main(String[] args) {
		EqualHashcodeTest test = new EqualHashcodeTest();
		test.test();
		test.test2();
	}

	public void test() {
		TestClass t1 = new TestClass();
		t1.a = 1;

		TestClass t2 = new TestClass();
		t2.a = 1;

		Map<TestClass, Integer> map = new HashMap<>();
		map.put(t1, 1);
		map.put(t2, 2);
		System.out.println("重写了hashCode()和equals()两个方法的结果：" + map.size());
	}

	public void test2() {
		TestClass2 t1 = new TestClass2();
		t1.a = 1;

		TestClass2 t2 = new TestClass2();
		t2.a = 1;

		Map<TestClass2, Integer> map = new HashMap<>();
		map.put(t1, 1);
		map.put(t2, 2);
		System.out.println("没有重写hashCode()和equals()两个方法的结果：" + map.size());
	}

	class TestClass2 {
		int a;
	}

	class TestClass {
		int a;

		@Override
		public int hashCode() {
			return Objects.hash(a);
		}

		// equals 的结果限定了两个对象是不是同一个的标准
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof TestClass)) {
				return false;
			}

			TestClass test = (TestClass) obj;
			return a == test.a;
		}
	}
}
