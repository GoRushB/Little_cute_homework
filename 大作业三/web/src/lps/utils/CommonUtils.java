package lps.utils;

import java.sql.*;

public class CommonUtils {
	/** * ����ĵ���ģʽ */
	private static CommonUtils instance;

	public static CommonUtils getInstance() {
		if (instance == null)
			instance = new CommonUtils();
		return instance;
	}

	/** * ��ȡ���ݿ����� */
	public Connection getDatabaseConnection() {
		String url = "jdbc:sqlite::resource:ansdb.db3";
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}