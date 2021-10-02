package com.servlet;

import java.io.IOException;
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

import com.util.HibernateUtil;

/**
 * Servlet implementation class CLassController
 */
@WebServlet("/classes")
public class CLassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CLassController() {
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
		 
		 Query q2 = sessionHb.createQuery("from Classes ");
		 List <Classes> classesList = (List<Classes>) q2.list();
		 
		 request.setAttribute("classesList", classesList);
		 
		 sessionHb.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if (sessionHb != null) {
				sessionHb.close();
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("classes.jsp");
		rd.forward(request, response);
	}

}