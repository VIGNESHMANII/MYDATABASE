package com.StudentMarksManagementApp.Repo;

import java.util.List;

import com.StudentMarksManagementApp.Entity.Marks;

public interface MarksRepo {
	
	/*
	 * public String AddFaculty(Faculty faculty);
	public List<Faculty> ShowAll();*?
	 */
	public String AddMarks(Marks marks);
	public List<Marks> ShowAll();

}
