package com.mysrc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mysrc.entity.Student;
import com.mysrc.entity.StudentRowMapper;

public class StudentDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Student getStudentById(int id) {
		return jdbcTemplate.queryForObject(
				"select * from tbl_student where id = ?", new Object[] { id },
				new StudentRowMapper());
	}

	public List<Student> getAllStudent() {
		return jdbcTemplate.query("select * from tbl_student",
				new StudentRowMapper());
	}

	public int insertStudent(Student student) {
		return jdbcTemplate.update(
				"insert into tbl_student(name,birth,score) values(?,?,?)",
				new Object[] { student.getName(), student.getBirth(),
						student.getScore() });
	}

	public int deleteStudent(int id) {
		return jdbcTemplate.update("delete from tbl_student where id = ? ",
				new Object[] { id });
	}

	public int updateStudent(Student student) {
		return jdbcTemplate.update(
				" update tbl_student set name=?,birth=?,score=? where id=? ",
				new Object[] { student.getName(), student.getBirth(),
						student.getScore(), student.getId() });
	}
}
