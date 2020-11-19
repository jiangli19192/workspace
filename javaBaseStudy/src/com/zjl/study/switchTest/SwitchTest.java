package com.zjl.study.switchTest;

// switch(expression) {
//     case value :
//         //语句 break;  //可选
//     case value : 
//         //语句 break;  //可选
//     //你可以有任意数量的case语句
//     default : //可选 
//         //语句 
// }

/**
 * ClassName : SwitchTest
 * 
 * @author 张江立
 * @date 2020年6月18日 下午5:37:32
 *
 */
public class SwitchTest {

	public static void main(String[] args) {
		// switchMethod("lfo");
		// System.out.println("-----------------cto--------------");
		// switchMethod("cto");
		// System.out.println("-----------------default--------------");
		// switchMethod("");
		//
		// System.out.println("-----------------B是:良好等级--------------");
		// switchMethod2('B');
		// System.out.println("-----------C也是:良好等级------------");
		// switchMethod2('C');

		// System.out.println("-----------------没有break语句,不匹配情况--------------");
		// switchMethod3(5);

//		System.out.println("-----------------没有break语句,匹配情况--------------");
//		switchMethod4(1);
		
		System.out.println("-----------------匹配case,后续的case语句有break;会跳出此switch--------------");
		switchMethod5(1);
	}

	static void switchMethod(String mode) {
		switch (mode) {
		case "lfo":
			System.out.println("lfo");
			break;
		case "cto":
		default:
			System.out.println("lfo");
			System.out.println("cto");
		}
	}

	/**
	 * switch case 执行时，一定会先进行匹配，匹配成功返回当前 case 的值，再根据是否有 break，判断是否继续输出，或是跳出判断。
	 * 
	 * @param grade
	 */
	static void switchMethod2(char grade) {
		switch (grade) {
		case 'A':
			System.out.println("优秀");
		case 'B':
			System.out.println("grade=B时, 因为没有break; 会继续执行下一个case");
		case 'C':
			System.out.println("良好");
			break;
		case 'D':
			System.out.println("及格");
			break;
		default:
			System.out.println("未知等级");
		}

		System.out.println("你的等级是 " + grade);
	}

	/**
	 * 如果 case 语句块中没有 break 语句时，JVM 并不会顺序输出每一个 case 对应的返回值， 而是继续匹配，匹配不成功则返回默认
	 * case。
	 * 
	 * @param i
	 */
	static void switchMethod3(int i) {
		switch (i) {
		case 0:
			System.out.println("0");
		case 1:
			System.out.println("1");
		case 2:
			System.out.println("2");
		default:
			System.out.println("default");
		}
	}

	/**
	 * 如果 case 语句块中没有 break 语句时，匹配成功后，从当前 case 开始，后续所有 case 的值都会输出。
	 * 
	 * @param i
	 */
	static void switchMethod4(int i) {
		switch (i) {
		case 0:
			System.out.println("0");
		case 1:
			System.out.println("1");
		case 2:
			System.out.println("2");
		default:
			System.out.println("default");
		}
	}

	static void switchMethod5(int i) {
		switch (i) {
		case 0:
			System.out.println("0");
		case 1:
			System.out.println("1");
		case 2:
			System.out.println("2");
		case 3:
			System.out.println("3");
			break;
		default:
			System.out.println("default");
		}
	}
}
