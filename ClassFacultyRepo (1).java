package com.StudentMarksManagementApp.Repo;

import java.util.List;

import com.StudentMarksManagementApp.Entity.ClassFaculty;

public interface ClassFacultyRepo {
	
	public String MapClassFaculty(ClassFaculty clsf);
	public List<ClassFaculty> ShowAll();

}
