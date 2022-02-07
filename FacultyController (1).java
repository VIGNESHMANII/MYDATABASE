package com.StudentMarksManagementApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.StudentMarksManagementApp.Entity.Faculty;
import com.StudentMarksManagementApp.Repo.FacultyRepoImpl;
@Controller
public class FacultyController {

	@Autowired
	FacultyRepoImpl fr;
	
	@GetMapping("addNewf")
	public String AddFaculty(Model m)
	{
		return "Faculty";
	}
	
	@GetMapping("showAll")
	public String ShowAll(Model m)
	{
		List<Faculty> elist=fr.ShowAll();
		if(elist!=null)
		{
			m.addAttribute("elist", elist);
		}
		else
		{
			m.addAttribute("msg","Can't display!");
		}
		return "Faculty";
	}
	
	@PostMapping("addNewfprocess")
	public String AddProcess(@RequestParam String fid,@RequestParam String factName,@RequestParam String gender,
			@RequestParam String address,@RequestParam String location,@RequestParam String phone,@RequestParam String email,@RequestParam String password,Model m)
	{
		Faculty e=new Faculty();
		e.setFid(fid);
		e.setFactName(factName);
		e.setGender(gender);
		e.setAddress(address);
		e.setLocation(location);
		e.setPhone(phone);
		e.setEmail(email);
		e.setPassword(password);
		String r=fr.AddFaculty(e);
		m.addAttribute("msg",r);
		return "Faculty";
	}
}
