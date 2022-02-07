package com.StudentMarksManagementApp.Repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.StudentMarksManagementApp.Entity.Class;
@Component
public class ClassRepoImpl implements ClassRepo {

	@Autowired
	JdbcTemplate jt;
	
	@Override
	public String AddClass(Class cls) {
		// TODO Auto-generated method stub
		String str="Insert into ClassInfo(className) values(?)";
		int r= jt.update(str, new Object[] {cls.getClassName()});
		if(r>=1)
		   return "Class Added";
		else
			return "Error ...";
	}

	@Override
	public List<Class> ShowAll() {
		// TODO Auto-generated method stub
		String str="Select * from ClassInfo";
		List<Class> listAll=jt.query(str, new BeanPropertyRowMapper(Class.class));
		return listAll;
	}
}
