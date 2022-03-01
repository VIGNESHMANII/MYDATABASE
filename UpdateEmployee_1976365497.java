package com.java.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.*;
public class UpdateEmployee {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Employee emp = new Employee();
		System.out.println("New Name for an Employee ");
		emp.setEmpname(sc.next());
		System.out.println("Employee Number to Modify");
		emp.setEmpno(sc.nextInt());
					
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
			
		Query q = s.createQuery("update Employee set empname=:mname where empno=:eno");
		q.setParameter("mname", emp.getEmpname());
		q.setParameter("eno", emp.getEmpno());
		int r = q.executeUpdate();
		if(r>=1)
		{
			t.commit();
			System.out.println("Updated");
		}		
		s.close();
		sf.close();		
	}
}
