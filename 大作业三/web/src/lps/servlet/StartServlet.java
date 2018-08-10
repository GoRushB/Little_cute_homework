package lps.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lps.logic.StartLogic;

/**
 * Servlet implementation class StartServlet
 */
@WebServlet("/jsp/StartServlet")
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StartServlet() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config); // ��һ��
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	/***
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int ans = Integer.parseInt(request.getParameter("answers"));
		// ��ѡ���ѡ��value
		String uname = request.getParameter("uname");// ��ǰ�����˵�����
		int qid = Integer.parseInt(request.getParameter("qid"));
		// ���ǵ�ǰ���qid
		String action = request.getParameter("action"); // ��������
		int question_num = Integer.parseInt(request
				.getParameter("question_num")); // ���ǵ������һҳ��ı��
		int question_count = Integer.parseInt(request
				.getParameter("question_count")); // ��Ŀ����
		StartLogic instance = StartLogic.getInstance();
		boolean insOk = instance.setAnswer(uname, qid, ans);
		if (!insOk) {
			return;
		}
		try {
			switch (action) {
			case "goFirst":
				instance.goFirst(request, response, getServletContext(),
						question_num, qid, uname, question_count);
				break;
			case "goPrev":
				instance.goPrev(request, response, getServletContext(),
						question_num, qid, uname, question_count);
				break;
			case "goNext":
				instance.goNext(request, response, getServletContext(),
						question_num, qid, uname, question_count);
				break;
			case "goLast":
				instance.goLast(request, response, getServletContext(),
						question_num, qid, uname, question_count);
				break;
			case "gotoResult":
				instance.toResult(request, response, getServletContext(), uname);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}