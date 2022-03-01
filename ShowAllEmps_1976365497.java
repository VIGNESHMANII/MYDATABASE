package com.java.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ShowAllEmps {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Query<Employee> query=s.createQuery("from Employee");
		List<Employee>  emplist = query.list();
		
		for(Employee e : emplist)
		{
			System.out.println(e.getEmpno() + "\t" + e.getEmpname() + "\t" + e.getJob() + "\t" + e.getSal());
		}
		s.close();
		sf.close();
	}

}
