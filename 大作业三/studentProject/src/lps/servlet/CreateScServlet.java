package lps.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lps.pojo.Sc;
import lps.repo.ScRepository;

@WebServlet("/CreateScServlet")
public class CreateScServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateScServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String scid = request.getParameter("scid");
		String sno = request.getParameter("sno");
		String cno = request.getParameter("cno");
		String grade = request.getParameter("grade");
		String nextUrl = "";
		if (isScExist(scid)) {
			String valueString = "Id已被使用";
			request.setAttribute("message", valueString);
			nextUrl = "/jsp/CreateCourse.jsp";
		} else if (isStudentResultExist(sno, cno)) {
			String valueString = "已存在成绩";
			request.setAttribute("message", valueString);
			nextUrl = "/jsp/CreateCourse.jsp";
		} else {
			Sc sc = new Sc();
			sc.setScid(scid);
			sc.setSno(sno);
			sc.setCno(cno);
			sc.setGrade(grade);
			ScRepository.getInstance().create(sc);
			nextUrl = "/jsp/Sc.jsp";
		}
		getServletContext().getRequestDispatcher(nextUrl).forward(request,
				response);
	}

	private boolean isScExist(String scid) {
		return ScRepository.getInstance().getById(scid) == null;
	}

	private boolean isStudentResultExist(String studentid, String courseid) {
		return ScRepository.getInstance().getByStudentIdAndCourseId(studentid,
				courseid) == null;
	}
}
