package lps.logic;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lps.pojo.Answers;
import lps.pojo.Users;
import lps.repo.AnswersRepo;
import lps.repo.UsersRepo;

public class ResultLogic {
	private static ResultLogic instance = null;

	public static ResultLogic getInstance() {
		if (instance == null)
			instance = new ResultLogic();
		return instance;
	}

	public void WriteJSONQidAndGrade(HttpServletRequest request,
			HttpServletResponse response, int uid) {
		try {
			UsersRepo uRepo = UsersRepo.getInstance();
			Users users = uRepo.getById(uid);
			AnswersRepo aRepo = AnswersRepo.getInstance();
			List<Answers> anss = aRepo.retrieveByUsers(users);
			String json = aRepo.retrieveJSONQidAndGrade(anss);
			System.out.println(json);
			PrintWriter pw = response.getWriter();
			pw.print(json);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除某个用户答题
	 */
	public void deletePerson(HttpServletRequest request,
			HttpServletResponse response, ServletContext context, int uid) {
		try {
			UsersRepo uRepo = UsersRepo.getInstance();
			Users users = uRepo.getById(uid);
			AnswersRepo aRepo = AnswersRepo.getInstance();
			boolean isDel = aRepo.deleteByUsers(users);
			if (isDel) {
				uRepo.delete(users);
			}
			users = uRepo.getFirst();
			request.setAttribute("users", users);
			request.setAttribute("chengjis", _getChengJis());
			String nextpage = "/jsp/grade.jsp";
			RequestDispatcher disp = context.getRequestDispatcher(nextpage);
			disp.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取成绩列表
	 */
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