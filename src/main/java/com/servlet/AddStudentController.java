package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Classes;
import com.entity.Student;
import com.util.HibernateUtil;

/**
 * Servlet implementation class AddStudentController
 */
@WebServlet("/add-student")
public class AddStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStudentController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("add-student.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String classId = request.getParameter("classId");
		if (fName.length() < 1 || lName.length() < 1 || lName.length() < 1) {
			request.setAttribute("errorMessage", "all fields are mandatory");
			request.getRequestDispatcher("add-student.jsp").forward(request, response);

		} else {
			

			SessionFactory sf = HibernateUtil.buildSessionFactory();
			Session sessionHb = null;

			try {
				sessionHb = sf.openSession();
				sessionHb.beginTransaction();
				Integer id = Integer.parseInt(classId);
				Classes course = (Classes) sessionHb.get(Classes.class, id);
				
				Student std = new Student();
				std.setfName(fName);
				std.setlName(lName);
				std.setCourse(course);
				
				sessionHb.save(std);

			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("errorMessage", "something went wrong, try again later");
				request.getRequestDispatcher("add-student.jsp").forward(request, response);

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
			request.getRequestDispatcher("add-student.jsp").forward(request, response);
			
		}

	}

}
