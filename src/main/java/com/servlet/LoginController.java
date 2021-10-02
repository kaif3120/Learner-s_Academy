package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Classes;
import com.entity.Student;
import com.entity.Subject;
import com.entity.Teacher;
import com.util.HibernateUtil;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(email.equals("admin@test.com") && password.equals("admin")) {
			
			SessionFactory sf = HibernateUtil.buildSessionFactory();
			Session sessionHb = null;
			HttpSession session = request.getSession();
			
			try {
			 sessionHb = sf.openSession();
			 sessionHb.beginTransaction();
			   
			 Query q1 = sessionHb.createQuery("from Classes");
			 List <Classes> classList = (List <Classes>) q1.list();
			 
			
			 Query q4 = sessionHb.createQuery("from Teacher");
			 List <Teacher> tchList = (List <Teacher>) q4.list();
			 
			 session.setAttribute("classList", classList);
			 session.setAttribute("tchList", tchList);
			
			 
			 sessionHb.getTransaction().commit();
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				if (sessionHb != null) {
					sessionHb.close();
				}
			}
	     session.setAttribute("username", email);  
		 response.sendRedirect("masterlist.jsp");
		}else {
	    request.setAttribute("errorMessage", "Invalid Credentials");  
		request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}

}
