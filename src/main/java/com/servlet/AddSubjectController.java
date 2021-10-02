package com.servlet;

import java.io.IOException;
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
import com.entity.Subject;
import com.entity.Teacher;
import com.util.HibernateUtil;

/**
 * Servlet implementation class AddSubjectController
 */
@WebServlet("/add-subject")
public class AddSubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSubjectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("add-subject.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String subName = request.getParameter("subName");
		String classId = request.getParameter("classId");
		String teacherId = request.getParameter("teacherId");

		
		if (subName.length() < 1 || classId.length() < 1 || teacherId.length() < 1) {
			request.setAttribute("errorMessage", "all fields are mandatory");
			request.getRequestDispatcher("add-subject.jsp").forward(request, response);

		} else {
			

			SessionFactory sf = HibernateUtil.buildSessionFactory();
			Session sessionHb = null;

			try {
				sessionHb = sf.openSession();
				sessionHb.beginTransaction();
				Integer cid = Integer.parseInt(classId);
				Integer tid = Integer.parseInt(teacherId);
				Classes course = (Classes) sessionHb.get(Classes.class, cid);
				Teacher teacher = (Teacher) sessionHb.get(Teacher.class, tid);
				
				Subject sub = new Subject();
				sub.setSubjectName(subName);
				sub.setTeacher(teacher);
				sub.setCourse(course);
				
				sessionHb.save(sub);

			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("errorMessage", "something went wrong, try again later");
				request.getRequestDispatcher("add-subject.jsp").forward(request, response);

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
			request.getRequestDispatcher("add-subject.jsp").forward(request, response);
			
		}
		
	}

}
