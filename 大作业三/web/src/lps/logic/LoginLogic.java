package lps.logic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lps.pojo.Answers;
import lps.pojo.Questions;
import lps.pojo.Users;
import lps.repo.AnswersRepo;
import lps.repo.QuestionsRepo;
import lps.repo.UsersRepo;

public class LoginLogic {
	private static LoginLogic instance = null;

	public static LoginLogic getInstance() {
		if (instance == null)
			instance = new LoginLogic();
		return instance;
	}

	/**
	 * �ж��û��Ƿ����
	 */
	public boolean validateLoginIn(String uname) throws SQLException {
		UsersRepo repo1 = UsersRepo.getInstance();
		Users u = repo1.getByUname(uname);
		if (u == null)
			return false;
		return true;
	}

	/**
	 * �û�����������
	 */
	public void doQuestion(HttpServletRequest req, HttpServletResponse resp,
			ServletContext context, Users users) throws SQLException,
			ServletException, IOException {
		boolean isOldUsers = validateLoginIn(users.getUname());
		String nextjsp = "";
		if (isOldUsers) {
			String valueString = "���û������ٴ���";
			req.setAttribute("message", valueString);
			nextjsp = "/jsp/home.jsp";
		} else {
			UsersRepo uRepo = UsersRepo.getInstance();
			boolean insOk = uRepo.create(users); // �´�����Ҫ�������ݿ��o
			if (insOk) {
				req.setAttribute("users", users);
				req.setAttribute("question_num", 1);
				QuestionsRepo repo = QuestionsRepo.getInstance();
				Questions questions = repo.getFirst();
				int question_count = repo.getCount(); // ��Ŀ����
				req.setAttribute("questions", questions);
				req.setAttribute("question_count", question_count);
				nextjsp = "/jsp/question.jsp";
			}
		}
		RequestDispatcher disp = context.getRequestDispatcher(nextjsp);
		disp.forward(req, resp);
	}

	/**
	 * �û�����鿴���ҳ��
	 */
	public void gotoResult(HttpServletRequest req, HttpServletResponse resp,
			ServletContext context, Users users) throws SQLException,
			ServletException, IOException {
		boolean isOldUsers = validateLoginIn(users.getUname());
		String nextjsp = "";
		if (isOldUsers) {
			nextjsp = "/jsp/grade.jsp";
			UsersRepo uRepo = UsersRepo.getInstance();
			users = uRepo.getByUname(users.getUname());
			req.setAttribute("users", users);
			req.setAttribute("chengjis", _getChengJis());
		} else {
			String valueString = "���û����ܲ鿴�ɼ�";
			req.setAttribute("message", valueString);
			nextjsp = "/jsp/home.jsp";
		}
		RequestDispatcher disp = context.getRequestDispatcher(nextjsp);
		disp.forward(req, resp);
	}

	/**
	 * ���õ�½����
	 */
	public void reset(HttpServletRequest req, HttpServletResponse resp,
			RequestDispatcher disp) throws ServletException, IOException {
		disp.forward(req, resp);
	}

	/*** ��ȡÿ���û��Ĵ���ɼ���Ϣ������ֵ��װ�гɼ���Ϣ���б� */
	private List<ChengJi> _getChengJis() {
		List<ChengJi> list = new ArrayList<>();
		try {
			UsersRepo uRepo = UsersRepo.getInstance();
			AnswersRepo aRepo = AnswersRepo.getInstance();
			for (Users users : uRepo.retrieve()) {
				List<Answers> anss = aRepo.retrieveByUsers(users);
				double grade = 0;
				for (Answers answers : anss) {
					grade += answers.getGrade();
				}
				ChengJi cj = new ChengJi(users.getUid(), users.getUname(),
						grade);
				list.add(cj);
			}
			Collections.sort(list);
			Collections.reverse(list);
			for (int i = 0; i < list.size(); i++) {
				list.get(i).setCjid(i + 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}