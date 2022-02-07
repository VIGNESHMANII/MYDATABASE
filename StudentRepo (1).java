package com.StudentMarksManagementApp.Repo;

import java.util.List;

import com.StudentMarksManagementApp.Entity.Student;

public interface StudentRepo {
	
	public String AddStudent(Student std);
	public List<Student> ShowAll();

}
