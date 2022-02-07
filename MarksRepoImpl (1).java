package com.StudentMarksManagementApp.Repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.StudentMarksManagementApp.Entity.Faculty;
import com.StudentMarksManagementApp.Entity.Marks;
@Component
public class MarksRepoImpl implements MarksRepo {

	@Autowired
	JdbcTemplate jt;
	
	@Override
	public String AddMarks(Marks marks) {
		// TODO Auto-generated method stub
		String str="Insert into marksInfo(examtype,science,math,computers,total,average,grade,rollno,classId,fid) values(?,?,?,?,?,?,?,?,?,?)";
		int r= jt.update(str, new Object[] {marks.getExamtype(), marks.getScience(), marks.getMath(), marks.getComputers(), marks.getTotal(), marks.getAverage(), marks.getGrade(), marks.getRollno(), marks.getClassId(), marks.getFid()});
		if(r>=1)
			return "Marks Added";
		else
			return "error";
	}

	@Override
	public List<Marks> ShowAll() {
		// TODO Auto-generated method stub
		String str="Select * from MarksIno";
		List<Marks> listAll=jt.query(str, new BeanPropertyRowMapper(Marks.class));
		return listAll;
	}

}
