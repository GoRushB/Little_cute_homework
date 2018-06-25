package generic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VisitDb {
    public static VisitDb db = new VisitDb();
    private static Connection conn = null;
    private static Statement state =null;
    public static VisitDb getDBconn() {
        if (null == db) {
            db = new VisitDb();
        }
        return db;
    }
    public static Connection getConn() {
        String url = "jdbc:sqlite:E:\\bh3DB.db3";
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void Establish(){
        try {
            VisitDb.getDBconn();
    		conn = VisitDb.getConn();
			state = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    public static boolean ExecuteInvoke(String sql){
    	try {
			return state.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
    }
    public static ResultSet ExecuteQueryInvoke(String sql){
    	try {
			return state.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
    }
    public static void Close(){
    	try {
			conn.close();
	    	state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}