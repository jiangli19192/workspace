package com.zjl.study.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zjl.study.mybatis.models.User;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = Resources
				.getResourceAsStream("Configuration.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			User user = (User) session
					.selectOne(
							"com.jsoft.testmybatis.models.UserMapper.selectUserByID",
							1);
			System.out.println(user.getUserAddress());
			System.out.println(user.getUserName());
		} finally {
			session.close();
		}
	}
}
