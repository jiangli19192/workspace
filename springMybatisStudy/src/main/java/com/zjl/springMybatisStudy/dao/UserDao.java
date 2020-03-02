package com.zjl.springMybatisStudy.dao;
import java.util.List;

import com.zjl.springMybatisStudy.model.User;

public interface UserDao {

	public User queryById(int id);
	
	public void save(User u);
	
	public void update(User u);
	
	public void delete(Integer id);
	
	public List<User> queryAll();
}