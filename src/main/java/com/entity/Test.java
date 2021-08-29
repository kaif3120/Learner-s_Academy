package com.entity;



import com.util.HibernateUtil;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class Test {

	public static void main(String[] args) {
		
		  SessionFactory sf = HibernateUtil.buildSessionFactory();
		  Session session = sf.openSession();
		  session.beginTransaction();
		  
		  
		  
//		  Classes course1 = new Classes();
//		  
//		  course1.setClassName("Java Full Stack");
//		  
//		  Classes course2 = new Classes();
//		  
//		  course2.setClassName("JavaScript Full Stack");
//		  
//		  Classes course3 = new Classes();
//		  
//		  course3.setClassName("Python Full Stack");
//		  
//		
//		  
//		  
//		  
//		  
//		  Teacher t1 = new Teacher ();
//		  t1.setfName("Akshay");
//		  t1.setlName("Nimkar");
//		  
//		  Teacher t2 = new Teacher ();
//		  t2.setfName("Manish");
//		  t2.setlName("Kumar");
//		  
//		  Teacher t3 = new Teacher ();
//		  t3.setfName("Neha");
//		  t3.setlName("Jagtiyani");
//		  
//		  Teacher t4 = new Teacher ();
//		  t4.setfName("Javed");
//		  t4.setlName("Shaikh");
//		  
//		  Teacher t5 = new Teacher ();
//		  t5.setfName("Manoj");
//		  t5.setlName("Sharma");
//		  
//		  Teacher t6 = new Teacher ();
//		  t6.setfName("Swati");
//		  t6.setlName("sarvekar");
//		  
//		  
//		  
//		  Subject sub1 = new Subject();
//		  sub1.setSubjectName("Core Java");
//		  sub1.setCourse(course1);
//		  sub1.setTeacher(t1);
//		  
//		  Subject sub2 = new Subject();
//		  sub2.setSubjectName("Advanced Java");
//		  sub2.setCourse(course1);
//		  sub2.setTeacher(t2);
//		  
//		  Subject sub3 = new Subject();
//		  sub3.setSubjectName("Spring Boot");
//		  sub3.setCourse(course1);
//		  sub3.setTeacher(t3);
//		  
//		  Subject sub11 = new Subject();
//		  sub11.setSubjectName("JavaScript");
//		  sub11.setCourse(course2);
//		  sub11.setTeacher(t4);
//		  
//		  Subject sub12 = new Subject();
//		  sub12.setSubjectName("Node.Js");
//		  sub12.setCourse(course2);
//		  sub12.setTeacher(t1);
//		  
//		  Subject sub13 = new Subject();
//		  sub13.setSubjectName("Reactjs");
//		  sub13.setCourse(course2);
//		  sub13.setTeacher(t5);
//		  
//		  Subject sub21 = new Subject();
//		  sub21.setSubjectName("JavaScript");
//		  sub21.setCourse(course3);
//		  sub21.setTeacher(t4);
//		  
//		  Subject sub22 = new Subject();
//		  sub22.setSubjectName("Node.Js");
//		  sub22.setCourse(course3);
//		  sub22.setTeacher(t6);
//		  
//		  Subject sub23 = new Subject();
//		  sub23.setSubjectName("Reactjs");
//		  sub23.setCourse(course3);
//		  sub23.setTeacher(t5);
//		  
//		  
//		  List<Subject> class1sub = new ArrayList<>();
//		  class1sub.add(sub1);
//		  class1sub.add(sub2);
//		  class1sub.add(sub3);
//		  course1.setSubjects(class1sub);
//		  
//		  List<Subject> class2sub = new ArrayList<>();
//		  class2sub.add(sub11);
//		  class2sub.add(sub12);
//		  class2sub.add(sub13);
//		  course2.setSubjects(class2sub);
//		  
//		  List<Subject> class3sub = new ArrayList<>();
//		  class3sub.add(sub21);
//		  class3sub.add(sub22);
//		  class3sub.add(sub23);
//		  course3.setSubjects(class3sub);
//		 
//		  
//		  
//		  
//		  
//		  
//		  
//		  
//		  		  
//		  Student s1 = new Student();
//		
//		  s1.setfName("Kaif");
//		  s1.setlName("Shaikh");
//		  s1.setCourse(course1);
//		  
//		  Student s2 = new Student();
//		 
//		  s2.setfName("Laman");
//		  s2.setlName("Khan");
//		  s2.setCourse(course1);
//		  
//		  Student s3 = new Student();
//		
//		  s3.setfName("Himanshi");
//		  s3.setlName("Pradhan");
//		  s3.setCourse(course1);
//		  
//		  Student s4 = new Student();
//	
//		  s4.setfName("Yogesh");
//		  s4.setlName("Meghwal");
//		  s4.setCourse(course1);
//		  
//		  Student s5 = new Student();
//		
//		  s5.setfName("Prehen");
//		  s5.setlName("Patel");
//		  s5.setCourse(course1);
//
//		
//		  
//		  Student s11 = new Student();
//		 
//		  s11.setfName("Ryan");
//		  s11.setlName("Gosling");
//		  s11.setCourse(course2);
//		  
//		  Student s12 = new Student();
//		  
//		  s12.setfName("Emma");
//		  s12.setlName("Stone");
//		  s12.setCourse(course2);
//		  
//		  Student s13 = new Student();
//		 
//		  s13.setfName("Steve");
//		  s13.setlName("Carell");
//		  s13.setCourse(course2);
//		  
//		  Student s14 = new Student();
//		
//		  s14.setfName("Brad");
//		  s14.setlName("Pitt");
//		  s14.setCourse(course2);
//		  
//		  Student s15 = new Student();
//		 
//		  s15.setfName("Rusell");
//		  s15.setlName("Crowe");
//		  s15.setCourse(course2);
//
//		  
//		 
//		  
//		  Student s21 = new Student();
//			 
//		  s21.setfName("Ross");
//		  s21.setlName("Geller");
//		  s21.setCourse(course3);
//		  
//		  Student s22 = new Student();
//		  
//		  s22.setfName("Chandler");
//		  s22.setlName("Bing");
//		  s22.setCourse(course3);
//		  
//		  Student s23 = new Student();
//		 
//		  s23.setfName("Monica");
//		  s23.setlName("Geller");
//		  s23.setCourse(course3);
//		  
//		  Student s24 = new Student();
//		
//		  s24.setfName("Rachel");
//		  s24.setlName("Green");
//		  s24.setCourse(course3);
//		  
//		  Student s25 = new Student();
//		 
//		  s25.setfName("Pheobe");
//		  s25.setlName("Buffay");
//		  s25.setCourse(course3);
//		  
//		  Student s26 = new Student();
//			 
//		  s26.setfName("Joey");
//		  s26.setlName("Tribbiani");
//		  s26.setCourse(course3);
//		  
//		 
//		  
//		  
//		  
//		  session.save(course1);
//		  session.save(course2);
//		  session.save(course3);
//	
//		  session.save(t1);
//		  session.save(t2);
//		  session.save(t3);
//		  session.save(t4);
//		  session.save(t5);
//		  session.save(t6);
//		  
//		  
//		  session.save(s1);
//		  session.save(s2);
//		  session.save(s3);
//		  session.save(s4);
//		  session.save(s5);
//		  
//		  session.save(s11);
//		  session.save(s12);
//		  session.save(s13);
//		  session.save(s14);
//		  session.save(s15);
//		  
//		  session.save(s21);
//		  session.save(s22);
//		  session.save(s23);
//		  session.save(s24);
//		  session.save(s25);
//		  session.save(s26);
//		  
//		  session.save(sub1);
//		  session.save(sub2);
//		  session.save(sub3);
//		  
//		  session.save(sub11);
//		  session.save(sub12);
//		  session.save(sub13);
//		  
//		  session.save(sub21);
//		  session.save(sub22);
//		  session.save(sub23);
//		  
//		
//		  
		  
		 Query q = session.createQuery("from Subject where class_id = 10001");
		 List <Subject> sl = (List <Subject>) q.list();
		 for(Subject subject : sl) {
			 System.out.println(subject.getSubjectName() + " " +subject.getTeacher().getfName() +" " +subject.getTeacher().getlName()   + " " +subject.getCourse().getClassName());
		 }
		 
		  session.getTransaction().commit();

	}

}
