package com.zjl.java8.study.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * 根据对象属性字段给list集合去重 ClassName : RemoveDuplicationUser
 * 
 * @author 张江立
 * @date 2018年6月12日 下午3:24:08
 *
 */
public class RemoveDuplicationUser {
	public static void main(String[] args) {
		List<User> userList = new ArrayList<User>();
		User user1 = new User("张三", "001");
		userList.add(user1);
		User user2 = new User("李四", "001");
		userList.add(user2);
		User user3 = new User("王五", "002");
		userList.add(user3);
		for (User u : userList) {
			System.out.println(u.getName());
		}
		System.out.println("去重后=======>");
		long startTime=System.currentTimeMillis();
		List<User> userListNoDupAndSort = removeDuplicateUser(userList);
		for (User u : userListNoDupAndSort) {
			System.out.println(u.getName());
		}
		long endTime=System.currentTimeMillis();
		System.out.println("take time:" + (endTime - startTime) + "ms;" + (endTime - startTime) / 1000 + "s" );
		
		System.out.println("去重后_2  比较耗时=======>");
		long startTime_2=System.currentTimeMillis();
		List<User> userListNoDupAndSort_2 = removeDuplicateUser_2(userList);
		for (User u : userListNoDupAndSort_2) {
			System.out.println(u.getName());
		}
		long endTime_2=System.currentTimeMillis();
		System.out.println("take time:" + (endTime_2 - startTime_2) + "ms;" + (endTime_2 - startTime_2) / 1000 + "s" );
		
		System.out.println("去重后_3  =======>");
		long startTime_3=System.currentTimeMillis();
		List<User> userListNoDupAndSort_3 = removeDuplicateUser_3(userList);
		for (User u : userListNoDupAndSort_3) {
			System.out.println(u.getName());
		}
		long endTime_3=System.currentTimeMillis();
		System.out.println("take time:" + (endTime_3 - startTime_3) + "ms;" + (endTime_3 - startTime_3) / 1000 + "s" );
	}

	private static ArrayList<User> removeDuplicateUser(List<User> users) {
		Set<User> set = new TreeSet<User>(new Comparator<User>() {
			@Override
			public int compare(User o1, User o2) {
				// 字符串,则按照asicc码升序排列
				return o1.getUserId().compareTo(o2.getUserId());
			}
		});
		set.addAll(users);
		return new ArrayList<User>(set);
	}
	
	private static ArrayList<User> removeDuplicateUser_2(List<User> users) {
		Set<User> set = new TreeSet<User>(Comparator.comparing(User::getUserId));
		set.addAll(users);
		return new ArrayList<User>(set);
	}
	
	private static List<User> removeDuplicateUser_3(List<User> users) {
		Map<String, User> userIdUserMap = new HashMap<>();
		users.forEach(user -> {
			String userId = user.getUserId();
			if (!userIdUserMap.containsKey(userId)) {
				userIdUserMap.put(userId, user);
			}
		});
		
		List<User> userList = userIdUserMap.values().stream().map(user -> user).collect(Collectors.toList());
		userIdUserMap.clear();
		return userList;
	}
}

class User {
	private String name;
	private String userId;

	public User(String name, String userId) {
		this.name = name;
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
