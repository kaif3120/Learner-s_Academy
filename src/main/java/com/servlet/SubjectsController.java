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

import com.entity.Subject;
import com.entity.Teacher;
import com.util.HibernateUtil;

/**
 * Servlet implementation class SubjectsController
 */
@WebServlet("/subjects")
public class SubjectsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session sessionHb = null;
		
		try {
		 sessionHb = sf.openSession();
		 sessionHb.beginTransaction();
		 
		 Query q2 = sessionHb.createQuery("from Subject ");
		 List <Subject> subList = (List<Subject>) q2.list();
		 
		 request.setAttribute("subjectsList", subList);
		 
		 sessionHb.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if (sessionHb != null) {
				sessionHb.close();
			}
		}   
		
				RequestDispatcher rd = request.getRequestDispatcher("subjects.jsp");
				rd.forward(request, response);
	}
}
