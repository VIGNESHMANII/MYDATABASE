package com.StudentMarksManagementApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.StudentMarksManagementApp.Entity.Class;
import com.StudentMarksManagementApp.Repo.ClassRepo;
@Controller
public class ClassController {
	
	@Autowired
	ClassRepo cr;
	
	@GetMapping("/")
	public String WelcomePage()
	{
		return "Login";
	}
	
	@PostMapping("login")
	public String loginProcess(@RequestParam String username,@RequestParam String password,Model m)
	{
		if(username.equals("smmadmin")&&password.equals("smmadmin"))
		{
			return "Adminwelcome";
		}
		else
			m.addAttribute("msg","Wrong username/password");
		return "Login";
	}
	
	/*@GetMapping("addclass")
	public String AddClass() {
		return "Classes";
	}*/
	
	@PostMapping("showall")
	public String AddClass(@RequestParam String classname, Model m) {
		Class cls=new Class();
		cls.setClassName(classname);
		
		String result=cr.AddClass(cls);
		m.addAttribute("msg", result);
		List<Class> clsAll=cr.ShowAll();
		System.out.println(clsAll);
		m.addAttribute("clsAll", clsAll);
		return "Classes";
	}
	
	@GetMapping("showall")
	public String ShowAll(Model m) {
		List<Class> clsAll=cr.ShowAll();
		System.out.println(clsAll);
		m.addAttribute("clsAll", clsAll);
		return "Classes";
	}

}
