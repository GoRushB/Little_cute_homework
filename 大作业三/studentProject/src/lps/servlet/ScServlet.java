package lps.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lps.logic.ScLogic;

@WebServlet("/ScServlet")
public class ScServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ScServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ScLogic logic = ScLogic.getInstance();
		String action = request.getParameter("action");
		String id = request.getParameter("id");
		switch (action) {
		case "GetAll":
			logic.GetAll(request, response);
			break;
		case "Create":
			logic.Create(request, response, getServletContext());
			break;
		case "Edit":
			logic.Edit(request, response, getServletContext(), id);
			break;
		case "Delete":
			logic.Delete(request, response, getServletContext(), id);
			break;
		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
}
