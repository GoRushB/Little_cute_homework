package lps.logic;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lps.helper.JsonHelper;
import lps.pojo.Sc;
import lps.repo.ScRepository;

public class ScLogic {
	private static ScLogic instance = null;

	public static ScLogic getInstance() {
		if (instance == null)
			instance = new ScLogic();
		return instance;
	}

	public void GetAll(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Sc> chengji = ScRepository.getInstance().retrieve();
			PrintWriter pw = response.getWriter();
			pw.print("{" + JsonHelper.ListToJson("chengji", chengji) + "}");
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Create(HttpServletRequest request,
			HttpServletResponse response, ServletContext context) {
		try {
			String nextUrl = "/jsp/CreateSc.jsp";
			context.getRequestDispatcher(nextUrl).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Edit(HttpServletRequest request, HttpServletResponse response,
			ServletContext context, String id) {
		try {
			request.setAttribute("Sc", ScRepository.getInstance().getById(id));
			String nextUrl = "/jsp/EditSc.jsp";
			context.getRequestDispatcher(nextUrl).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void Delete(HttpServletRequest request,
			HttpServletResponse response, ServletContext context, String id) {
		try {
			ScRepository.getInstance().delete(id);
			String nextUrl = "/jsp/Sc.jsp";
			context.getRequestDispatcher(nextUrl).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}