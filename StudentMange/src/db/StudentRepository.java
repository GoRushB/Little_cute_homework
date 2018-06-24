package db;

import generic.IDao;
import generic.VisitDb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentRepository implements IDao<Student> {
    public boolean Create(Student t) {
        try{
            Connection conn = VisitDb.getDBconn().getConn();
            Statement state = conn.createStatement();
            String sql = String.format("insert into student(sno,sname,sage) values('%s','%s','%d')",t.getSno(), t.getSname(), t.getSage());
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

    public ArrayList<Student> Retrieve() {
        ArrayList<Student> arrs = new ArrayList<>();
        try{
            Connection conn = VisitDb.getDBconn().getConn();
            Statement state = conn.createStatement();
            String sql = String.format("selete * from student  ");
            ResultSet rs = state.executeQuery(sql);
            while(rs.next()){
                Student st =new Student();
                st.setSno(rs.getString("sno"));
                st.setSname(rs.getString("sname"));
                st.setSage(rs.getInt("sage"));
                arrs.add(st);
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

    public boolean Updata(Student oldt, Student newt) {
        try{
            Connection conn = VisitDb.getDBconn().getConn();
            Statement state = conn.createStatement();
            String sql = String.format("update student set sname='%s',sage='%d where sno ='%s'",newt.getSname(),newt.getSage(),oldt.getSno());
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

    public boolean Delete(Student t) {
        try{
            Connection conn = VisitDb.getDBconn().getConn();
            Statement state = conn.createStatement();
            String sql = String.format("delete from student where sno ='%s'", t.getSno());
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

    public Student getById(String id) {
        try{
            Connection conn = VisitDb.getDBconn().getConn();
            Statement state = conn.createStatement();
            String sql = String.format("selete * from student where sno ='%s'",id);
            ResultSet rs = state.executeQuery(sql);
            if(rs.next()){
               Student st =new Student();
                st.setSno(rs.getString("sno"));
                st.setSname(rs.getString("sname"));
                st.setSage(rs.getInt("sage"));
                state.close();
                conn.close();
                return st;
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