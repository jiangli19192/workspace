package com.zjl.springMybatisStudy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjl.springMybatisStudy.dao.UserDao;
import com.zjl.springMybatisStudy.model.User;
import com.zjl.springMybatisStudy.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public User queryById(int id) {
		return userDao.queryById(id);
	}

	@Override
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void delete(Integer id) {
		userDao.delete(id);
	}

	@Override
	public List<User> queryAll() {
		return userDao.queryAll();
	}

}
