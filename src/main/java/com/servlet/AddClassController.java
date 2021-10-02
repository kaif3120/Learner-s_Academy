package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Classes;
import com.entity.Student;
import com.entity.Teacher;
import com.util.HibernateUtil;

/**
 * Servlet implementation class AddClassController
 */
@WebServlet("/add-class")
public class AddClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClassController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("add-class.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String className = request.getParameter("className");
		HttpSession session = request.getSession();
		
		if (className.length() < 1 ) {
			request.setAttribute("errorMessage", "all fields are mandatory");
			request.getRequestDispatcher("add-class.jsp").forward(request, response);

		} else {
			

			SessionFactory sf = HibernateUtil.buildSessionFactory();
			Session sessionHb = null;

			try {
				sessionHb = sf.openSession();
				sessionHb.beginTransaction();
				
				Classes cls = new Classes();
				cls.setClassName(className);
				
				sessionHb.save(cls);

				
				Query q = sessionHb.createQuery("from Classes");
				List<Classes> tchList = q.list();
				
				session.removeAttribute("classList");
				session.setAttribute("classList", tchList);
				
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("errorMessage", "something went wrong, try again later");
				request.getRequestDispatcher("add-class.jsp").forward(request, response);

			} finally {
				if (sessionHb != null) {
					try {
						sessionHb.getTransaction().commit();
						sessionHb.close();
					} catch (HibernateException e) {
						e.printStackTrace();
										     	}
			     	}
			 }
			request.setAttribute("successMessage", "sucessfully added");
			request.getRequestDispatcher("add-class.jsp").forward(request, response);
			
		}
		
		
	}

}
