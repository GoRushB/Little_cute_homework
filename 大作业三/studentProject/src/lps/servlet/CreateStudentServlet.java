package lps.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lps.pojo.Student;
import lps.repo.StudentRepository;

@WebServlet("/CreateStudentServlet")
public class CreateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateStudentServlet() {
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
		String nextUrl = "";
		if (isStudnetExist(sno)) {
			String valueString = "Id已被使用";
			request.setAttribute("message", valueString);
			nextUrl = "/jsp/CreateStudent.jsp";
		} else {
			Student student = new Student();
			student.setSno(sno);
			student.setSname(sname);
			student.setSage(sage);
			StudentRepository.getInstance().create(student);
			nextUrl = "/jsp/Student.jsp";
		}
		getServletContext().getRequestDispatcher(nextUrl).forward(request,
				response);
	}

	private boolean isStudnetExist(String id) {
		return StudentRepository.getInstance().getById(id) == null;
	}
}
