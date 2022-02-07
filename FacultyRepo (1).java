package com.StudentMarksManagementApp.Repo;

import java.util.List;

import com.StudentMarksManagementApp.Entity.Faculty;

public interface FacultyRepo {
	
	public String AddFaculty(Faculty faculty);
	public List<Faculty> ShowAll();

}
