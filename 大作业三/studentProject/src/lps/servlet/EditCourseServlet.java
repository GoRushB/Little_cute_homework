package lps.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lps.pojo.Course;
import lps.repo.CourseRepository;

@WebServlet("/EditCourseServlet")
public class EditCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditCourseServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cno = request.getParameter("cno");
		String cname = request.getParameter("cname");
		String cprior = request.getParameter("cprior");
		Course course = new Course();
		course.setCno(cno);
		course.setCname(cname);
		course.setCprior(cprior);
		CourseRepository.getInstance().update(
				CourseRepository.getInstance().getById(cno), course);
		String nextUrl = "/jsp/Course.jsp";
		getServletContext().getRequestDispatcher(nextUrl).forward(request,
				response);
	}
}
