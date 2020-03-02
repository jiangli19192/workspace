package com.mysrc.service;

import java.sql.Date;
import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mysrc.dao.StudentDao;
import com.mysrc.entity.Student;

public class StudentService {
	private StudentDao dao;

	public void setDao(StudentDao dao) {
		this.dao = dao;
	}

	@Transactional(propagation = Propagation.NESTED, timeout = 1000, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class, noRollbackFor = CustomRuntimeException.class)
	public void doComplexLogic() {

		// select
		List<Student> list = dao.getAllStudent();
		for (Student student : list) {
			System.out.println(student);
		}

		// update
		Student student = list.get(0);
		student.setName("zhejiang");
		dao.updateStudent(student);
		System.out.println("did update temporarily...");

		// int a = 9 / 0; // �����쳣����������ع�
		// ���try catch��������쳣�������������˳��ִ�У�����ع�

		int b = 2;
		if (b > 1) {
			throw new CustomRuntimeException();
			// ���񲻻�ع���Ҳ���������update�������ύ
		}

		// insert
		student = new Student();
		student.setName("hello");
		student.setBirth(new Date(354778));
		student.setScore(78.9f);
		dao.insertStudent(student);
		System.out.println("did insert...");

		// delete
		dao.deleteStudent(3);
		System.out.println("did delete...");
	}

	class CustomRuntimeException extends RuntimeException {
		public CustomRuntimeException() {
			super();
		}

		public CustomRuntimeException(String msg) {
			super(msg);
		}
	}
}
