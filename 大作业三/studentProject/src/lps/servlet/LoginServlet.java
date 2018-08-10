package lps.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String nextUrl = "";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (!username.equals("admin") || !password.equals("lps")) {
			String valueString = "’À∫≈ªÚ√‹¬Î¥ÌŒÛ";
			request.setAttribute("message", valueString);
			nextUrl = "/jsp/Index.jsp";
		} else {
			nextUrl = "/jsp/Menu.jsp";
		}
		getServletContext().getRequestDispatcher(nextUrl).forward(request,
				response);
	}
}
