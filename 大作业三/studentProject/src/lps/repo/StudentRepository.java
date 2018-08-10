package lps.repo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lps.pojo.Student;
import lps.utils.CommonUtils;

public class StudentRepository implements IRepo<Student> {
	private static StudentRepository instance = null;

	public static StudentRepository getInstance() {
		if (instance == null)
			instance = new StudentRepository();
		return instance;
	}

	@Override
	public boolean create(Student t) {
		boolean success = false;
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement state = conn.createStatement();
			state.setQueryTimeout(30);
			String sql = String.format(
					"insert into student(sno,sname,sage) values('%s','%s',%s)",
					t.getSno(), t.getSname(), t.getSage());
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
	public List<Student> retrieve() {
		List<Student> arrs = new ArrayList<Student>();
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement state = conn.createStatement();
			state.setQueryTimeout(30);
			String sql = String.format("select * from student ");
			ResultSet rs = state.executeQuery(sql);
			while (rs.next()) {
				Student st = new Student();
				st.setSno(rs.getString("sno"));
				st.setSname(rs.getString("sname"));
				st.setSage(rs.getString("sage"));
				arrs.add(st);
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
	public boolean update(Student oldt, Student newt) {
		boolean success = false;
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement state = conn.createStatement();
			state.setQueryTimeout(30);
			String sql = String.format(
					"update student set sname='%s',sage=%s where sno ='%s'",
					newt.getSname(), newt.getSage(), oldt.getSno());
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
			String sql = String.format("delete from student where sno ='%s'",
					id);
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

	public Student getById(String id) {
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement state = conn.createStatement();
			state.setQueryTimeout(30);
			String sql = String.format("select * from student where sno ='%s'",
					id);
			ResultSet rs = state.executeQuery(sql);
			if (rs.next()) {
				Student st = new Student();
				st.setSno(rs.getString("sno"));
				st.setSname(rs.getString("sname"));
				st.setSage(rs.getString("sage"));
				state.close();
				conn.close();
				return st;
			}
			state.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}