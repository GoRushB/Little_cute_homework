package lps.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MenuServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String nextUrl = "";
		String action = request.getParameter("action");
		switch (action) {
		case "Student":
			nextUrl = "/jsp/Student.jsp";
			break;
		case "Course":
			nextUrl = "/jsp/Course.jsp";
			break;
		case "Sc":
			nextUrl = "/jsp/Sc.jsp";
			break;
		default:
			break;
		}
		getServletContext().getRequestDispatcher(nextUrl).forward(request,
				response);
	}
}
