package lps.repo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lps.pojo.Answers;
import lps.pojo.Questions;
import lps.pojo.Users;
import lps.utils.CommonUtils;

public class AnswersRepo implements IRepo<Answers> {
	private static AnswersRepo instance = null;

	public static AnswersRepo getInstance() {
		if (instance == null)
			instance = new AnswersRepo();
		return instance;
	}

	@Override
	public boolean create(Answers t) {
		boolean success = false;
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement state = conn.createStatement();
			state.setQueryTimeout(30);
			String sql = String
					.format("INSERT INTO answers (uid, ans, qid, adate, grade) VALUES (%d, %d, %d, '%s', %f)",
							t.getUid(), t.getAns(), t.getQid(), t.getAdate(),
							t.getGrade());
			int affectRows = state.executeUpdate(sql);
			conn.close();
			if (affectRows > 0)
				success = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public List<Answers> retrieve() {
		List<Answers> answerss = new ArrayList<Answers>();
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);
			ResultSet rs = statement
					.executeQuery("select * from answers order by aid");
			while (rs.next()) {
				Answers s = new Answers();
				s.setAid(rs.getInt("aid"));
				s.setUid(rs.getInt("uid"));
				s.setAns(rs.getInt("ans"));
				s.setQid(rs.getInt("qid"));
				s.setAdate(rs.getString("adate"));
				s.setGrade(rs.getDouble("grade"));
				answerss.add(s);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return answerss;
	}

	@Override
	public boolean update(Answers tOld, Answers tNew) {
		boolean success = false;
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);
			String sql = String
					.format("update answers set uid=%d, ans=%d, qid=%d, adate='%s', grade=%f where aid=%d",
							tNew.getUid(), tNew.getAns(), tNew.getQid(),
							tNew.getAdate(), tNew.getGrade(), tOld.getAid());
			int affectRows = statement.executeUpdate(sql);
			conn.close();
			if (affectRows > 0)
				success = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public boolean delete(Answers t) {
		boolean success = false;
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);
			String sql = String.format("delete from answers where aid=%d",
					t.getAid());
			int affectRows = statement.executeUpdate(sql);
			conn.close();
			if (affectRows > 0)
				success = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	public Answers getById(int id) {
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);
			String sql = String
					.format("select * from answers where aid=%d", id);
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				Answers s = new Answers();
				s.setAid(rs.getInt("aid"));
				s.setUid(rs.getInt("uid"));
				s.setAns(rs.getInt("ans"));
				s.setQid(rs.getInt("qid"));
				s.setAdate(rs.getString("adate"));
				s.setGrade(rs.getDouble("grade"));
				conn.close();
				return s;
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 找到某个人的所有答题数据
	 * 
	 * @param users
	 * @return @
	 */
	public List<Answers> retrieveByUsers(Users users) {
		List<Answers> answerss = new ArrayList<Answers>();
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);
			String sql = String.format(
					"select * from answers where uid=%d order by aid",
					users.getUid());
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Answers s = new Answers();
				s.setAid(rs.getInt("aid"));
				s.setUid(rs.getInt("uid"));
				s.setAns(rs.getInt("ans"));
				s.setQid(rs.getInt("qid"));
				s.setAdate(rs.getString("adate"));
				s.setGrade(rs.getDouble("grade"));
				answerss.add(s);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return answerss;
	}

	/**
	 * 找到某道题的所有答题数据
	 * 
	 * @param questions
	 * @return @
	 */
	public List<Answers> retrieveByQuestions(Questions questions) {
		List<Answers> answerss = new ArrayList<Answers>();
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);
			String sql = String.format(
					"select * from answers where qid=%d order by aid",
					questions.getQid());
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Answers s = new Answers();
				s.setAid(rs.getInt("aid"));
				s.setUid(rs.getInt("uid"));
				s.setAns(rs.getInt("ans"));
				s.setQid(rs.getInt("qid"));
				s.setAdate(rs.getString("adate"));
				s.setGrade(rs.getDouble("grade"));
				answerss.add(s);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return answerss;
	}

	/**
	 * 根据答案列表获得题号和成绩的
	 * 
	 * @param anss
	 * @return
	 */
	public String retrieveJSONQidAndGrade(List<Answers> anss) {
		String qidString = "", gradeString = "";
		for (Answers answers : anss) {
			qidString += " " + answers.getQid();
			gradeString += " " + answers.getGrade();
		}
		qidString = qidString.trim().replace(' ', ',');
		gradeString = gradeString.trim().replace(' ', ',');
		String jsonString = "{\"qid\":[" + qidString + "],\"grade\":["
				+ gradeString + "]}";
		return jsonString;
	}

	/**
	 * 根据uid和qid找答案
	 * 
	 * @param uid
	 * @param qid
	 *            * @return @
	 */
	public Answers getByUidAndQid(int uid, int qid) {
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);
			String sql = String.format(
					"select * from answers where uid=%d and qid=%d", uid, qid);
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				Answers s = new Answers();
				s.setAid(rs.getInt("aid"));
				s.setUid(rs.getInt("uid"));
				s.setAns(rs.getInt("ans"));
				s.setQid(rs.getInt("qid"));
				s.setAdate(rs.getString("adate"));
				s.setGrade(rs.getDouble("grade"));
				conn.close();
				return s;
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 删除某用户的所有答题
	 * 
	 * @param users
	 * @return @
	 */
	public boolean deleteByUsers(Users users) {
		boolean success = false;
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);
			String sql = String.format("delete from answers where uid=%d",
					users.getUid());
			int affectRows = statement.executeUpdate(sql);
			conn.close();
			if (affectRows > 0)
				success = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}
}