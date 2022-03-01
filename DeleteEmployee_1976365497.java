package com.java.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.*;
public class DeleteEmployee {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Employee Number to Delete");
		int eno = sc.nextInt();
					
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
			
		Query q = s.createQuery("delete from Employee where empno=:eno");		
		q.setParameter("eno", eno);
		int r = q.executeUpdate();
		if(r>=1)
		{
			t.commit();
			System.out.println("Deleted");
		}		
		s.close();
		sf.close();		
	}
}
