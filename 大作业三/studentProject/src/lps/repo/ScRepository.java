package lps.repo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lps.pojo.Sc;
import lps.utils.CommonUtils;

public class ScRepository implements IRepo<Sc> {
	private static ScRepository instance = null;

	public static ScRepository getInstance() {
		if (instance == null)
			instance = new ScRepository();
		return instance;
	}

	@Override
	public boolean create(Sc t) {
		boolean success = false;
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement state = conn.createStatement();
			state.setQueryTimeout(30);
			String sql = String.format(
					"insert into sc(sno,cno,grade) values('%s','%s',%s)",
					t.getSno(), t.getCno(), t.getGrade());
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
	public List<Sc> retrieve() {
		List<Sc> arrs = new ArrayList<Sc>();
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement state = conn.createStatement();
			state.setQueryTimeout(30);
			String sql = String.format("select * from sc ");
			ResultSet rs = state.executeQuery(sql);
			while (rs.next()) {
				Sc sc = new Sc();
				sc.setScid(rs.getString("scid"));
				sc.setSno(rs.getString("sno"));
				sc.setCno(rs.getString("cno"));
				sc.setGrade(rs.getString("grade"));
				arrs.add(sc);
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
	public boolean update(Sc oldt, Sc newt) {
		boolean success = false;
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement state = conn.createStatement();
			state.setQueryTimeout(30);
			String sql = String.format(
					"update sc set sno='%s' ,cno='%s' ,grade=%s where scid=%s",
					newt.getSno(), newt.getCno(), newt.getGrade(),
					oldt.getScid());
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
			String sql = String.format("delete from sc where scid =%s", id);
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

	public Sc getById(String id) {
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement state = conn.createStatement();
			state.setQueryTimeout(30);
			String sql = String.format("select * from sc where scid =%s", id);
			ResultSet rs = state.executeQuery(sql);
			if (rs.next()) {
				Sc sc = new Sc();
				sc.setScid(rs.getString("scid"));
				sc.setSno(rs.getString("sno"));
				sc.setCno(rs.getString("cno"));
				sc.setGrade(rs.getString("grade"));
				state.close();
				conn.close();
				return sc;
			}
			state.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteByStudentId(String id) {
		boolean success = false;
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);
			String sql = String.format("delete from sc where sno=%s", id);
			int affectRows = statement.executeUpdate(sql);
			conn.close();
			if (affectRows > 0)
				success = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	public boolean deleteByCourseId(String id) {
		boolean success = false;
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);
			String sql = String.format("delete from sc where cno=%s", id);
			int affectRows = statement.executeUpdate(sql);
			conn.close();
			if (affectRows > 0)
				success = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	public Sc getByStudentIdAndCourseId(String studentid, String courseid) {
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement state = conn.createStatement();
			state.setQueryTimeout(30);
			String sql = String.format(
					"select * from student where sno ='%s' and cno = '%s'",
					studentid, courseid);
			ResultSet rs = state.executeQuery(sql);
			if (rs.next()) {
				Sc sc = new Sc();
				sc.setScid(rs.getString("scid"));
				sc.setSno(rs.getString("sno"));
				sc.setCno(rs.getString("cno"));
				sc.setGrade(rs.getString("grade"));
				state.close();
				conn.close();
				return sc;
			}
			state.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}