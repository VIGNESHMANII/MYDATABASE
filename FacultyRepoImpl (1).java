package com.StudentMarksManagementApp.Repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.StudentMarksManagementApp.Entity.Faculty;
@Component
public class FacultyRepoImpl implements FacultyRepo {

	@Autowired
	JdbcTemplate jt;
	
	@Override
	public String AddFaculty(Faculty faculty) {
		// TODO Auto-generated method stub
		String str= "Insert into FacultyInfo(fid, factName, gender, address, location, phone, email, password) values(?,?,?,?,?,?,?,?)";
		int r= jt.update(str, new Object[] {faculty.getFid(), faculty.getFactName(), faculty.getGender(),faculty.getAddress(),faculty.getLocation(),faculty.getPhone(),faculty.getEmail(),faculty.getPassword()});
		if(r>=1)
		   return "Class Added";
		else
			return "Error ...";
	}

	@Override
	public List<Faculty> ShowAll() {
		// TODO Auto-generated method stub
		String str="Select * from FacultyInfo";
		List<Faculty> listAll=jt.query(str, new BeanPropertyRowMapper(Faculty.class));
		return listAll;
	}

}
