package lps.logic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
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

public class StartLogic {
	private static StartLogic instance = null;

	public static StartLogic getInstance() {
		if (instance == null) {
			instance = new StartLogic();
		}
		return instance;
	}

	/**
	 * ����һ����¼
	 */
	public void goFirst(HttpServletRequest request,
			HttpServletResponse response, ServletContext context,
			int question_num, int qid, String uname, int question_count)
			throws ServletException, IOException, SQLException {
		String nextpage = "/jsp/question.jsp";
		request.setAttribute("question_num", question_num);
		request.setAttribute("question_count", question_count);
		QuestionsRepo qrepo = QuestionsRepo.getInstance();
		Questions questions = qrepo.getFirst();
		request.setAttribute("questions", questions);
		_setAttrUsersAndAns(request, questions, uname);
		context.getRequestDispatcher(nextpage).forward(request, response);
	}

	/**
	 * ����һ����¼
	 */
	public void goPrev(HttpServletRequest request,
			HttpServletResponse response, ServletContext context,
			int question_num, int qid, String uname, int question_count)
			throws ServletException, IOException, SQLException {
		String nextpage = "/jsp/question.jsp";
		request.setAttribute("question_num", question_num);
		request.setAttribute("question_count", question_count);
		QuestionsRepo qrepo = QuestionsRepo.getInstance();
		Questions questions = qrepo.getPrev(qid);
		request.setAttribute("questions", questions);
		_setAttrUsersAndAns(request, questions, uname);
		context.getRequestDispatcher(nextpage).forward(request, response);
	}

	/**
	 * ����һ����¼
	 */
	public void goNext(HttpServletRequest request,
			HttpServletResponse response, ServletContext context,
			int question_num, int qid, String uname, int question_count)
			throws ServletException, IOException, SQLException {
		String nextpage = "/jsp/question.jsp";
		request.setAttribute("question_num", question_num);
		request.setAttribute("question_count", question_count);
		QuestionsRepo qrepo = QuestionsRepo.getInstance();
		Questions questions = qrepo.getNext(qid);
		request.setAttribute("questions", questions);
		_setAttrUsersAndAns(request, questions, uname);
		context.getRequestDispatcher(nextpage).forward(request, response);
	}

	/**
	 * �����һ����¼
	 */
	public void goLast(HttpServletRequest request,
			HttpServletResponse response, ServletContext context,
			int question_num, int qid, String uname, int question_count)
			throws ServletException, IOException, SQLException {
		String nextpage = "/jsp/question.jsp";
		request.setAttribute("question_num", question_num);
		request.setAttribute("question_count", question_count);
		QuestionsRepo qrepo = QuestionsRepo.getInstance();
		Questions questions = qrepo.getLast();
		request.setAttribute("questions", questions);
		_setAttrUsersAndAns(request, questions, uname);
		context.getRequestDispatcher(nextpage).forward(request, response);
	}

	/**
	 * �鿴�ɼ�
	 */
	public void toResult(HttpServletRequest request,
			HttpServletResponse response, ServletContext context, String uname)
			throws ServletException, IOException {
		try {
			String nextpage = "/jsp/grade.jsp";
			UsersRepo uRepo = UsersRepo.getInstance();
			Users users = uRepo.getByUname(uname);
			request.setAttribute("users", users);
			request.setAttribute("chengjis", _getChengJis());
			context.getRequestDispatcher(nextpage).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �ѳɼ�¼��ĳ�û�������Ϣ
	 */
	public boolean setAnswer(String uname, int qid, int ans) {
		boolean insOk = false;
		try {
			UsersRepo uRepo = UsersRepo.getInstance();
			int uid;
			uid = uRepo.getByUname(uname).getUid();
			Answers answers = new Answers();
			answers.setUid(uid);
			answers.setQid(qid);
			answers.setAns(ans);
			answers.setAdate(new Date().toString());
			QuestionsRepo qRepo = QuestionsRepo.getInstance();
			Questions q = qRepo.getById(qid);
			int right_ans = q.getRight_ans();
			int point = q.getPoints();
			if (right_ans == ans) {
				answers.setGrade(point);
			} else {
				answers.setGrade(0);
			}
			AnswersRepo aRepo = AnswersRepo.getInstance();
			Answers answers2 = aRepo.getByUidAndQid(uid, qid);
			// �����û���û����������⣬û�����������
			if (answers2 == null) { // �¼�¼����
				insOk = aRepo.create(answers);
				return insOk;
			} else { // �ϼ�¼����
				insOk = aRepo.update(answers2, answers);
				return insOk;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return insOk;
	}

	/**
	 * ����������û��������õ�ǰ����ҳ��ѡ��״̬
	 */
	private void _setAttrUsersAndAns(HttpServletRequest request,
			Questions questions, String uname) {
		try {
			UsersRepo uRepo = UsersRepo.getInstance();
			Users users = uRepo.getByUname(uname);
			request.setAttribute("users", users);
			int uid = users.getUid();
			AnswersRepo aRepo = AnswersRepo.getInstance();
			Answers answers = aRepo.getByUidAndQid(uid, questions.getQid());
			if (answers != null) {
				request.setAttribute("anscheck", answers.getAns());
			} else {
				request.setAttribute("anscheck", 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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