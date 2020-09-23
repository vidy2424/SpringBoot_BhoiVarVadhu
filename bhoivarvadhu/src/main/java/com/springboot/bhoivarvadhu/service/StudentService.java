/*package com.springboot.bhoivarvadhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bhoivarvadhu.dao.StudentDAO;
import com.springboot.bhoivarvadhu.dto.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDAO studentDAO;

	public List<Student> get() {
		return studentDAO.get();
	}

	public Student save(Student student) {
		return studentDAO.save(student);
	}

	public void delete(int id) {
		studentDAO.delete(id);
	}
}
*/