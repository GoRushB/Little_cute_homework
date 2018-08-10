package lps.repo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lps.pojo.Users;
import lps.utils.CommonUtils;

public class UsersRepo implements IRepo<Users> {
	private static UsersRepo instance = null;

	public static UsersRepo getInstance() {
		if (instance == null)
			instance = new UsersRepo();
		return instance;
	}

	@Override
	public boolean create(Users t) {
		boolean success = false;
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement state = conn.createStatement();
			state.setQueryTimeout(30);
			String sql = String.format("insert into users(uname) values('%s')",
					t.getUname());
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
	public List<Users> retrieve() {
		List<Users> userss = new ArrayList<Users>();
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);
			ResultSet rs = statement.executeQuery("select * from users");
			while (rs.next()) {
				Users s = new Users();
				s.setUid(rs.getInt("uid"));
				s.setUname(rs.getString("uname"));
				userss.add(s);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userss;
	}

	@Override
	public boolean update(Users tOld, Users tNew) {
		boolean success = false;
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);
			String sql = String.format(
					"update users set uname='%s' where uid=%d",
					tNew.getUname(), tOld.getUid());
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
	public boolean delete(Users t) {
		boolean success = false;
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);
			String sql = String.format("delete from users where uid=%d",
					t.getUid());
			int affectRows = statement.executeUpdate(sql);
			conn.close();
			if (affectRows > 0)
				success = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	public Users getById(int id) {
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);
			String sql = String.format("select * from users where uid=%d", id);
			ResultSet rss = statement.executeQuery(sql);
			if (rss.next()) {
				Users temp = new Users();
				temp.setUid(rss.getInt("uid"));
				temp.setUname(rss.getString("uname"));
				conn.close();
				return temp;
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据用户名找到用户
	 * 
	 * @param uname
	 * @return
	 * @throws SQLException
	 */
	public Users getByUname(String uname) {
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);
			String sql = String.format("select * from users where uname='%s'",
					uname);
			ResultSet rss = statement.executeQuery(sql);
			if (rss.next()) {
				Users temp = new Users();
				temp.setUid(rss.getInt("uid"));
				temp.setUname(rss.getString("uname"));
				conn.close();
				return temp;
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Users getFirst() {
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30);
			String sql = String
					.format("select * from users order by uid limit 1");
			ResultSet rss = statement.executeQuery(sql);
			if (rss.next()) {
				Users temp = new Users();
				temp.setUid(rss.getInt("uid"));
				temp.setUname(rss.getString("uname"));
				conn.close();
				return temp;
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}