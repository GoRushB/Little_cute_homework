package lps.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lps.pojo.Student;
import lps.repo.StudentRepository;

@WebServlet("/EditStudentServlet")
public class EditStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditStudentServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String sno = request.getParameter("sno");
		String sname = request.getParameter("sname");
		String sage = request.getParameter("sage");
		Student student = new Student();
		student.setSno(sno);
		student.setSname(sname);
		student.setSage(sage);
		StudentRepository.getInstance().update(
				StudentRepository.getInstance().getById(sno), student);
		String nextUrl = "/jsp/Student.jsp";
		getServletContext().getRequestDispatcher(nextUrl).forward(request,
				response);
	}
}
