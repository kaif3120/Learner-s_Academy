package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Classes;
import com.entity.Student;
import com.entity.Subject;
import com.util.HibernateUtil;

/**
 * Servlet implementation class ShowClassController
 */
@WebServlet("/show-classes")
public class ShowClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowClassController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session sessionHb = null;
		String classId = request.getParameter("id");
		int clsId = Integer.parseInt(classId);
		
		try {
		 sessionHb = sf.openSession();
		 sessionHb.beginTransaction();
		   
		 Query q1 = sessionHb.createQuery("from Subject where class_id = '" + classId + "'");
		 List <Subject> subList = (List <Subject>) q1.list();
		 
		 Query q2 = sessionHb.createQuery("from Student where class_id = '" + classId + "'");
		 List <Student> stdList = (List<Student>) q2.list();
		 
		 Classes cls = (Classes)sessionHb.get(Classes.class, clsId);
		 String className = cls.getClassName();
		 
		 request.setAttribute("className", className);
		 request.setAttribute("sub1List", subList);
		 request.setAttribute("std1List", stdList);
		 
		 sessionHb.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if (sessionHb != null) {
				sessionHb.close();
			}
		}
        
		RequestDispatcher rd = request.getRequestDispatcher("show-class.jsp");
		rd.forward(request, response);

		
	}


	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
