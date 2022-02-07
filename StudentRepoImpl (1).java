package com.StudentMarksManagementApp.Repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.StudentMarksManagementApp.Entity.Student;
@Component
public class StudentRepoImpl implements StudentRepo {

	@Autowired
	JdbcTemplate jt;
	
	@Override
	public String AddStudent(Student std) {
		// TODO Auto-generated method stub
		String str="Insert into StudentReg(rollno, stdName, gender, address, location, phone, email, password, classId) values(?,?,?,?,?,?,?,?,?)";
		int r=jt.update(str, new Object[] {std.getRollno(),std.getStdName(),std.getGender(),std.getAddress(),std.getLocation(),std.getPhone(),std.getEmail(),std.getPassword(),std.getClassId()});
		if(r>=1)
			   return "Student Added";
			else
				return "Error ...";
	}

	@Override
	public List<Student> ShowAll() {
		// TODO Auto-generated method stub
		String str="Select * from StudentReg";
		List<Student> listAll=jt.query(str, new BeanPropertyRowMapper(Student.class));
		return listAll;
	}

}
