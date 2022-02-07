package com.StudentMarksManagementApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.StudentMarksManagementApp.Entity.Student;
import com.StudentMarksManagementApp.Repo.StudentRepo;

@Controller
public class StudentController {
	
	@Autowired
	StudentRepo sr;
	
	@GetMapping("addNewS")
	public String AddStudent(Model m)
	{
		return "Students";
	}
	
	@GetMapping("showAllS")
	public String ShowAll(Model m)
	{
		List<Student> elist=sr.ShowAll();
		if(elist!=null)
		{
			m.addAttribute("elist", elist);
		}
		else
		{
			m.addAttribute("msg","Can't display!");
		}
		return "Students";
	}
	
	@PostMapping("addNewSprocess")
	public String AddProcess(@RequestParam String rollno,@RequestParam String stdName,@RequestParam String gender,
			@RequestParam String address,@RequestParam String location,@RequestParam String phone,@RequestParam String email,@RequestParam String password,@RequestParam Integer classId,Model m)
	{
		Student e=new Student();
		e.setRollno(rollno);
		e.setStdName(stdName);
		e.setGender(gender);
		e.setAddress(address);
		e.setLocation(location);
		e.setPhone(phone);
		e.setEmail(email);
		e.setPassword(password);
		e.setClassId(classId);
		String r=sr.AddStudent(e);
		m.addAttribute("msg",r);
		return "showAllS";
	}

}
