package com.StudentMarksManagementApp.Repo;
import java.util.List;

import com.StudentMarksManagementApp.Entity.Class;
public interface ClassRepo {
	
	public String AddClass(Class cls);
	public List<Class> ShowAll();
}
