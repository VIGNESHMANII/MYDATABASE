package com.StudentMarksManagementApp.Repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.StudentMarksManagementApp.Entity.ClassFaculty;

public class ClassFacultyRepoImpl implements ClassFacultyRepo {

	@Autowired
	JdbcTemplate jt;
	
	@Override
	public String MapClassFaculty(ClassFaculty clsf) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<ClassFaculty> ShowAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
