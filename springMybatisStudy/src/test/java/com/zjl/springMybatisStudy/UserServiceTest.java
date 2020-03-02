package com.zjl.springMybatisStudy;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zjl.springMybatisStudy.model.User;
import com.zjl.springMybatisStudy.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/applicationContext.xml")
public class UserServiceTest {

	@Autowired
	UserService userService; 
	
	@Test
	public void testQueryById(){
		User u = userService.queryById(1);
		if(u != null){
			System.out.println(u);
		}
	}
	
	@Test
	public void testInsert() {
//		for(int i = 0; i < 100; i++){
			User u = new User();
			u.setUserName("whh");
			u.setPassword("sb");
			userService.save(u);
//		}
		System.out.println("保存成功！");
	}
	
	@Test
	public void testUpdate(){
		User u = userService.queryById(3);
		u.setUserName("scott");
		u.setPassword("scott");
		userService.update(u);
		System.out.println("修改成功！");
	}
	
	
	@Test
	public void testDelete(){
		int id = 4;
		userService.delete(id);
		
	}
	
	
	@Test
	public void testQueryAll(){
		List<User> users = userService.queryAll();
		if(users != null){
			for(int i = 0; i < users.size(); i++){
				System.out.println(users.get(i));
			}
		}
	}
}