package db;


import generic.IDao;
import generic.VisitDb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CourseRepository implements IDao<Course>{
    public boolean Create(Course t) {
        try{
            Connection conn = VisitDb.getDBconn().getConn();
            Statement state = conn.createStatement();
            String sql = String.format("insert into course(cno,cname,cprior) values('%s','%s',%lf)",t.getCno(), t.getCname(), t.getCprior());
            boolean b =state.execute(sql);
            state.close();
            conn.close();
            return b;
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Course> Retrieve() {
        ArrayList<Course> arrs = new ArrayList<>();
        try{
            Connection conn = VisitDb.getDBconn().getConn();
            Statement state = conn.createStatement();
            String sql = String.format("selete * from course  ");
            ResultSet rs = state.executeQuery(sql);
            while(rs.next()){
                Course co =new Course();
                co.setCno(rs.getString("cno"));
                co.setCname(rs.getString("cname"));
                co.setCprior(rs.getDouble("cprior"));
                arrs.add(co);
            }
            rs.close();
            state.close();
            conn.close();
            return arrs;
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public boolean Updata(Course oldt, Course newt) {
        try{
            Connection conn = VisitDb.getDBconn().getConn();
            Statement state = conn.createStatement();
            String sql = String.format("update course set cname='%s',cprior='%lf where cno ='%s'",newt.getCname(),newt.getCprior(),oldt.getCno());
            boolean b =state.execute(sql);
            state.close();
            conn.close();
            return b;
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public boolean Delete(Course t) {
        try{
            Connection conn = VisitDb.getDBconn().getConn();
            Statement state = conn.createStatement();
            String sql = String.format("delete from course where cno ='%s'", t.getCno());
            boolean b =state.execute(sql);
            state.close();
            conn.close();
            return b;
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public Course getById(String id) {
        try{
            Connection conn = VisitDb.getDBconn().getConn();
            Statement state = conn.createStatement();
            String sql = String.format("selete * from course where cno ='%s'",id);
            ResultSet rs = state.executeQuery(sql);
            if(rs!=null){
                Course co =new Course();
                co.setCno(rs.getString("cno"));
                co.setCname(rs.getString("cname"));
                co.setCprior(rs.getDouble("cprior"));
                state.close();
                conn.close();
                return co;
            }
            state.close();
            conn.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}