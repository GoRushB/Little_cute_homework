package lps.repo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lps.pojo.Questions;
import lps.utils.CommonUtils;

public class QuestionsRepo implements IRepo<Questions> {
	private static QuestionsRepo instance = null;

	public static QuestionsRepo getInstance() {
		if (instance == null)
			instance = new QuestionsRepo();
		return instance;
	}

	@Override
	public boolean create(Questions t) {
		boolean success = false;
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement state = conn.createStatement();
			state.setQueryTimeout(30);
			String sql = String
					.format("insert into questions(qdesp, qans1, qans2, qans3, qans4, points, right_ans) VALUES ('%s', '%s', '%s', '%s', '%s', %d, %d);",
							t.getQdesp(), t.getQans1(), t.getQans2(),
							t.getQans3(), t.getQans4(), t.getPoints(),
							t.getRight_ans());
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
	public List<Questions> retrieve() {
		List<Questions> questionss = new ArrayList<Questions>();
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);
			ResultSet rs = statement
					.executeQuery("select * from questions order by qid");
			while (rs.next()) {
				Questions s = new Questions();
				s.setQid(rs.getInt("qid"));
				s.setQdesp(rs.getString("qdesp"));
				s.setQans1(rs.getString("qans1"));
				s.setQans2(rs.getString("qans2"));
				s.setQans3(rs.getString("qans3"));
				s.setQans4(rs.getString("qans4"));
				s.setPoints(rs.getInt("points"));
				s.setRight_ans(rs.getInt("right_ans"));
				questionss.add(s);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return questionss;
	}

	@Override
	public boolean update(Questions tOld, Questions tNew) {
		boolean success = false;
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);
			String sql = String
					.format("update questions set qdesp='%s',qans1='%s',qans2='%s',qans3='%s',qans4='%s',points=%d,right_ans=%d where qid=%d",
							tNew.getQdesp(), tNew.getQans1(), tNew.getQans2(),
							tNew.getQans3(), tNew.getQans4(), tNew.getPoints(),
							tNew.getRight_ans(), tOld.getQid());
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
	public boolean delete(Questions t) {
		boolean success = false;
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);
			String sql = String.format("delete from questions where qid=%d",
					t.getQid());
			int affectRows = statement.executeUpdate(sql);
			conn.close();
			if (affectRows > 0)
				success = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	public Questions getById(int id) {
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);
			String sql = String.format("select * from questions where qid=%d",
					id);
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				Questions s = new Questions();
				s.setQid(rs.getInt("qid"));
				s.setQdesp(rs.getString("qdesp"));
				s.setQans1(rs.getString("qans1"));
				s.setQans2(rs.getString("qans2"));
				s.setQans3(rs.getString("qans3"));
				s.setQans4(rs.getString("qans4"));
				s.setPoints(rs.getInt("points"));
				s.setRight_ans(rs.getInt("right_ans"));
				conn.close();
				return s;
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/***
	 * 根据题目描述找到题
	 * 
	 * @param qdesp
	 * @return @
	 */
	public Questions getByQdesp(String qdesp) {
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);
			String sql = String.format(
					"select * from questions where qdesp='%s'", qdesp);
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				Questions s = new Questions();
				s.setQid(rs.getInt("qid"));
				s.setQdesp(rs.getString("qdesp"));
				s.setQans1(rs.getString("qans1"));
				s.setQans2(rs.getString("qans2"));
				s.setQans3(rs.getString("qans3"));
				s.setQans4(rs.getString("qans4"));
				s.setPoints(rs.getInt("points"));
				s.setRight_ans(rs.getInt("right_ans"));
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
	 * 获得第一道题
	 * 
	 * @return @
	 */
	public Questions getFirst() {
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);
			String sql = String
					.format("select * from questions order by qid limit 1");
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				Questions s = new Questions();
				s.setQid(rs.getInt("qid"));
				s.setQdesp(rs.getString("qdesp"));
				s.setQans1(rs.getString("qans1"));
				s.setQans2(rs.getString("qans2"));
				s.setQans3(rs.getString("qans3"));
				s.setQans4(rs.getString("qans4"));
				s.setPoints(rs.getInt("points"));
				s.setRight_ans(rs.getInt("right_ans"));
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
	 * 获取题目总数
	 * 
	 * @return @
	 */
	public int getCount() {
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);
			String sql = String
					.format("select count(qid) as number from questions");
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				int num = rs.getInt(1);
				conn.close();
				return num;
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	/**
	 * 获得最后一题
	 * 
	 * @return @
	 */
	public Questions getLast() {
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);
			String sql = String
					.format("select * from questions order by qid desc limit 1");
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				Questions s = new Questions();
				s.setQid(rs.getInt("qid"));
				s.setQdesp(rs.getString("qdesp"));
				s.setQans1(rs.getString("qans1"));
				s.setQans2(rs.getString("qans2"));
				s.setQans3(rs.getString("qans3"));
				s.setQans4(rs.getString("qans4"));
				s.setPoints(rs.getInt("points"));
				s.setRight_ans(rs.getInt("right_ans"));
				conn.close();
				return s;
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Questions getPrev(int qid) {
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);
			String sql = String
					.format("select * from questions where qid < %d order by qid desc limit 1",
							qid);
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				Questions s = new Questions();
				s.setQid(rs.getInt("qid"));
				s.setQdesp(rs.getString("qdesp"));
				s.setQans1(rs.getString("qans1"));
				s.setQans2(rs.getString("qans2"));
				s.setQans3(rs.getString("qans3"));
				s.setQans4(rs.getString("qans4"));
				s.setPoints(rs.getInt("points"));
				s.setRight_ans(rs.getInt("right_ans"));
				conn.close();
				return s;
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Questions getNext(int qid) {
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);
			String sql = String
					.format("select * from questions where qid > %d order by qid limit 1",
							qid);
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				Questions s = new Questions();
				s.setQid(rs.getInt("qid"));
				s.setQdesp(rs.getString("qdesp"));
				s.setQans1(rs.getString("qans1"));
				s.setQans2(rs.getString("qans2"));
				s.setQans3(rs.getString("qans3"));
				s.setQans4(rs.getString("qans4"));
				s.setPoints(rs.getInt("points"));
				s.setRight_ans(rs.getInt("right_ans"));
				conn.close();
				return s;
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}