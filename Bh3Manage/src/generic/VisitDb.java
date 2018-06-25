package generic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class VisitDb {
    public static VisitDb db = new VisitDb();
    private static Connection conn = null;
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
}