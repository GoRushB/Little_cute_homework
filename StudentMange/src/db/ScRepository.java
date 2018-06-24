package db;


import generic.IDao;
import generic.VisitDb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ScRepository implements IDao<Sc>{
    public boolean Create(Sc t) {
        try{
            Connection conn = VisitDb.getDBconn().getConn();
            Statement state = conn.createStatement();
            String sql = String.format("insert into sc(sno,cno,grade) values('%s','%s','%lf')",t.getSno(), t.getCno(), t.getGrade());
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

    public ArrayList<Sc> Retrieve() {
        ArrayList<Sc> arrs = new ArrayList<>();
        try{
            Connection conn = VisitDb.getDBconn().getConn();
            Statement state = conn.createStatement();
            String sql = String.format("selete * from sc  ");
            ResultSet rs = state.executeQuery(sql);
            while(rs.next()){
                Sc sc =new Sc();
                sc.setSno(rs.getString("sno"));
                sc.setCno(rs.getString("cno"));
                sc.setGrade(rs.getDouble("grade"));
                arrs.add(sc);
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

    public boolean Updata(Sc oldt, Sc newt) {
        try{
            Connection conn = VisitDb.getDBconn().getConn();
            Statement state = conn.createStatement();
            String sql = String.format("update sc set grade='%lf where sno ='%s'and cno ='%s'",newt.getGrade(),newt.getSno(),oldt.getCno());
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

    public boolean Delete(Sc t) {
        try{
            Connection conn = VisitDb.getDBconn().getConn();
            Statement state = conn.createStatement();
            String sql = String.format("delete from sc where sno ='%s' and cno ='%s'",t.getSno(),t.getCno());
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

    public Sc getById(String id) {
        return null;
    }
    public Sc getByStudentIdCourseId(String sid,String cid) {
        try{
            Connection conn = VisitDb.getDBconn().getConn();
            Statement state = conn.createStatement();
            String sql = String.format("selete * from sc where sno ='%s'and cno ='%s'",sid,cid);
            ResultSet rs = state.executeQuery(sql);
            if(rs!=null){
                Sc sc =new Sc();
                sc.setSno(rs.getString("sno"));
                sc.setCno(rs.getString("cno"));
                sc.setGrade(rs.getDouble("grade"));
                state.close();
                conn.close();
                return sc;
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