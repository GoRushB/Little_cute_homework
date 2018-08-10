package lps.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lps.logic.LoginLogic;
import lps.pojo.Users;

/**
 * Servlet implementation class LogicServlet
 */
@WebServlet(urlPatterns = { "/jsp/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		Users users = new Users();
		String uname = request.getParameter("uname");
		if (uname.trim().equals("") || uname == null) {
			String valueString = "用户名不能为空";
			request.setAttribute("message", valueString);
			String nextjsp = "/jsp/login.jsp";
			RequestDispatcher disp = getServletContext().getRequestDispatcher(
					nextjsp);
			disp.forward(request, response);
			return;
		}
		users.setUname(uname);
		LoginLogic instance = LoginLogic.getInstance();
		try {
			switch (action) {
			case "doquestion":
				instance.doQuestion(request, response, getServletContext(),
						users);
				break;
			case "gotoresult":
				instance.gotoResult(request, response, getServletContext(),
						users);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}