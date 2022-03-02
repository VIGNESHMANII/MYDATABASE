package com.hibernate.models;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.models.Person;

public class PersonMain {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Add New Person");
		System.out.println(" 2.Show All Persons");
		System.out.println("3.Search Person");
		System.out.println("4.Update Phone Number");
		System.out.println("5.Update Mail ID");
		System.out.println("6.Delete Person");
		System.out.println("");
		System.out.println("Enter Your Choice:");
		int option=sc.nextInt();

		while(true) {
		
			if(option==1) {
		Person per = new Person();		
		System.out.println("person Name ");
		per.setPersonName(sc.next());
		
		while(true) {
		System.out.println("Gender ");
		String gen=sc.next();
		if(gen.equals("male") || gen.equals("female"))
		{
			per.setGender(gen);
			break;
		}
		System.out.println("Enter valid input");
		}
		
		System.out.println("Location ");
		per.setLocation(sc.next());	
		
		while(true) {
		System.out.println("Phone Number ");
		String phn=sc.next();
		if(phn.matches("[7-9][0-9]{9}")) {
			per.setPhoneNumber(phn);
			break;
		}
		
			System.out.println("Enter valid input");
		
		}
		
		while(true) {
		System.out.println("Email ");
		String email=sc.next();
		if(email.matches("^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@"+"(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
		per.setEmail(email);	
		break;
		}
		
			System.out.println("Enter valid input");
		
		}
			
		s.save(per);
		t.commit();
		
		System.out.println("Person Data Created....");
		
		break;
			}
			else if(option==2) {
				Query<Person> query=s.createQuery("from Person");
				List<Person> perlist = query.list();
			
			
			for(Person p : perlist)
			{
				System.out.println(p.getPersonID() + "\t" + p.getPersonName() + "\t" + p.getGender() + "\t" + p.getLocation() +  "\t" + p.getEmail());
			}
			
			break;
			}
			else if(option==3) {
			
			
			String hql = "FROM Person  WHERE PersonID = 1";
			
			Query query = s.createQuery(hql);
			
			List<Person> perlist = query.list();
			
			//query = s.createQuery("from Person where PersonName=:p");
		//query.setParameter("p", "siri");
			//List<Person>  perlist = query.list();
			
			for(Person p : perlist)
			{
				System.out.println(p.getPersonID() + "\t" + p.getPersonName() + "\t" + p.getGender() + "\t" + p.getLocation() +  "\t" + p.getEmail());
			}
			
			
			break;
			}
			else if(option==4) {
				Person per = new Person();
				System.out.println("Person ID to Modify");
				per.setPersonID(sc.nextInt());
				System.out.println("New Number for person ");
				per.setPhoneNumber(sc.next());
				
			Query q = s.createQuery("update Person set PhoneNumber=:pnumber where PersonID=:pid");
			q.setParameter("pnumber", per.getPhoneNumber());
			q.setParameter("pid", per.getPersonID());
			int r = q.executeUpdate();
			if(r>=1)
			{
				t.commit();
				System.out.println("Updated");
			}		
				
			break;
			}
			else if(option==5) {
				Person per = new Person();
				System.out.println("Person ID to Modify");
				per.setPersonID(sc.nextInt());
				System.out.println("New Email for person ");
				per.setEmail(sc.next());
			Query q = s.createQuery("update Person set Email=:email where PersonID=:pid");
			q.setParameter("email", per.getEmail());
			q.setParameter("pid", per.getPersonID());
			int r = q.executeUpdate();
			if(r>=1)
			{
				t.commit();
				System.out.println("Updated");
			}		
			 
			break;
			}
			else if(option==6) {
				System.out.println("Person ID to Delete");
				int pid= sc.nextInt();
			Query q = s.createQuery("delete from Person  where PersonID=:pid");
			q.setParameter("pid",pid);	
			int r = q.executeUpdate();
			if(r>=1)
			{
				t.commit();
				System.out.println("Deleted");
			}		
			
			break;
			}
		
		s.close();
		sf.close();
		}
	}
}
