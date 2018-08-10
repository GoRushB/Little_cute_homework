package lps.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lps.pojo.Sc;
import lps.repo.ScRepository;

@WebServlet("/EditCourseServlet")
public class EditScServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditScServlet() {
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
		Sc sc = new Sc();
		sc.setScid(scid);
		sc.setSno(sno);
		sc.setCno(cno);
		sc.setGrade(grade);
		ScRepository.getInstance().update(
				ScRepository.getInstance().getById(scid), sc);
		String nextUrl = "/jsp/Sc.jsp";
		getServletContext().getRequestDispatcher(nextUrl).forward(request,
				response);
	}
}
