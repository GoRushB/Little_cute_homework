package lps.repo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lps.pojo.Course;
import lps.utils.CommonUtils;

public class CourseRepository implements IRepo<Course> {
	private static CourseRepository instance = null;

	public static CourseRepository getInstance() {
		if (instance == null)
			instance = new CourseRepository();
		return instance;
	}

	@Override
	public boolean create(Course t) {
		boolean success = false;
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement state = conn.createStatement();
			state.setQueryTimeout(30);
			String sql = String
					.format("insert into course(cno,cname,cprior) values('%s','%s',%s)",
							t.getCno(), t.getCname(), t.getCprior());
			int affectRows = state.executeUpdate(sql);
			state.close();
			conn.close();
			if (affectRows > 0)
				success = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public List<Course> retrieve() {
		List<Course> arrs = new ArrayList<>();
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement state = conn.createStatement();
			state.setQueryTimeout(30);
			String sql = String.format("select * from course ");
			ResultSet rs = state.executeQuery(sql);
			while (rs.next()) {
				Course co = new Course();
				co.setCno(rs.getString("cno"));
				co.setCname(rs.getString("cname"));
				co.setCprior(rs.getString("cprior"));
				arrs.add(co);
			}
			rs.close();
			state.close();
			conn.close();
			return arrs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(Course oldt, Course newt) {
		boolean success = false;
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement state = conn.createStatement();
			state.setQueryTimeout(30);
			String sql = String.format(
					"update course set cname='%s',cprior=%s where cno ='%s'",
					newt.getCname(), newt.getCprior(), oldt.getCno());
			int affectRows = state.executeUpdate(sql);
			state.close();
			conn.close();
			if (affectRows > 0)
				success = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public boolean delete(String id) {
		boolean success = false;
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement state = conn.createStatement();
			state.setQueryTimeout(30);
			String sql = String
					.format("delete from course where cno ='%s'", id);
			int affectRows = state.executeUpdate(sql);
			state.close();
			conn.close();
			if (affectRows > 0)
				success = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	public Course getById(String id) {
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement state = conn.createStatement();
			state.setQueryTimeout(30);
			String sql = String.format("select * from course where cno ='%s'",
					id);
			ResultSet rs = state.executeQuery(sql);
			if (rs.next()) {
				Course co = new Course();
				co.setCno(rs.getString("cno"));
				co.setCname(rs.getString("cname"));
				co.setCprior(rs.getString("cprior"));
				state.close();
				conn.close();
				return co;
			}
			state.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
}