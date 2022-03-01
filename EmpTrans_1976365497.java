package com.java.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

public class EmpTrans {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Query query=s.createQuery("select sum(sal) from Employee");
		List<Integer>  s_sal = query.list();

		System.out.println("Sum of Salary  for All Employees : " + s_sal.get(0));
		
		query = s.createQuery("Select max(sal) from Employee");
		List<Integer>  m_sal = query.list();
		System.out.println("Max Salary : " + m_sal.get(0));
		System.out.println("========================");
		query = s.createQuery("from Employee where job=:j");
		query.setParameter("j", "Tester");
		List<Employee>  emplist = query.list();
		
		for(Employee e : emplist)
		{
			System.out.println(e.getEmpno() + "\t" + e.getEmpname() + "\t" + e.getJob() + "\t" + e.getSal());
		}
		System.out.println("========================");
		
		Criteria c = s.createCriteria(Employee.class);
		c.add(Restrictions.eq("sal", 10000.00f));
		List<Employee>  emplst = c.list();
		
		for(Employee e : emplst)
		{
			System.out.println(e.getEmpno() + "\t" + e.getEmpname() + "\t" + e.getJob() + "\t" + e.getSal());
		}
		
		s.close();
		sf.close();
	}

}
