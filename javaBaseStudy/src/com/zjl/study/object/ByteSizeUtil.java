package com.zjl.study.object;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * 通过Java代码实现对象、List类集、数组、Map及常用数据类型等占用字节大小的代码示例 
 * ClassName : ByteSizeUtil
 * 
 * @author 张江立
 * @date 2020年7月7日 下午2:25:10
 *
 */
public class ByteSizeUtil {
	public static int getByteSize(List<?> datas) {
		int byteSize = 0;
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream os = new ObjectOutputStream(baos);
			os.writeObject(datas);
			os.close();
			byteSize = baos.size();
			System.out.println("ByteSizeUtil_getByteSize_datas>>>>>>>>>>>>【"
					+ byteSize + "】字节");
			baos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return byteSize;
	}

	public static int getByteSize(Object data) {
		int byteSize = 0;
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream os = new ObjectOutputStream(baos);
			os.writeObject(data);
			os.close();
			byteSize = baos.size();
			System.out.println("ByteSizeUtil_getByteSize_datas>>>>>>>>>>>>【"
					+ byteSize + "】字节");
			baos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return byteSize;
	}

	public static void main(String[] args) throws Exception {
		int n = 2000;
		List<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		getByteSize(list);
	}
}
