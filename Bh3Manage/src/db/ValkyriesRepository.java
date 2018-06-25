package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import db.Domain.Valkyries;
import generic.IDao;
import generic.VisitDb;

public class ValkyriesRepository implements IDao<Valkyries>{
    public boolean Create(Valkyries t) {
        try{
            Connection conn = VisitDb.getDBconn().getConn();
            Statement state = conn.createStatement();
            String sql = String.format("insert into valkyries(no,name,ratings,level,weapon,upperStigmata,centreStigmata,lowerStigmata) values('%s','%s','%s',%d,'%s','%s','%s','%s')",
            		t.getNo(),t.getName(),t.getRatings(),t.getLevel(),t.getWeapon(),t.getUpperStigmata(),t.getCentreStigmata(),t.getLowerStigmata());
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

    public ArrayList<Valkyries> Retrieve() {
        ArrayList<Valkyries> arrs = new ArrayList<>();
        try{
            Connection conn = VisitDb.getDBconn().getConn();
            Statement state = conn.createStatement();
            String sql = String.format("selete * from valkyries ");
            ResultSet rs = state.executeQuery(sql);
            while(rs.next()){
            	Valkyries v =new Valkyries();
                v.setNo(rs.getString("no"));
                v.setName(rs.getString("name"));
                v.setRatings(rs.getString("ratings"));
                v.setLevel(rs.getInt("level"));
                v.setWeapon(rs.getString("weapon"));
                v.setUpperStigmata(rs.getString("upperStigmata"));
                v.setCentreStigmata(rs.getString("centreStigmata"));
                v.setLowerStigmata(rs.getString("lowerStigmata"));
                arrs.add(v);
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

    public boolean Updata(Valkyries oldt, Valkyries newt) {
        try{
            Connection conn = VisitDb.getDBconn().getConn();
            Statement state = conn.createStatement();
            String sql = String.format("update valkyries set name='%s',ratings='%s',level=%d,weapon='%s',upperStigmata='%s',centreStigmata='%s',lowerStigmata='%s' where no ='%s'",
            		newt.getName(),newt.getRatings(),newt.getLevel(),newt.getWeapon(),newt.getUpperStigmata(),newt.getCentreStigmata(),newt.getLowerStigmata(),oldt.getNo());
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

    public boolean Delete(Valkyries t) {
        try{
            Connection conn = VisitDb.getDBconn().getConn();
            Statement state = conn.createStatement();
            String sql = String.format("delete from valkyries where no ='%s'", t.getNo());
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

    public Valkyries getById(String id) {
        try{
            Connection conn = VisitDb.getDBconn().getConn();
            Statement state = conn.createStatement();
            String sql = String.format("selete * from valkyries where no ='%s'",id);
            ResultSet rs = state.executeQuery(sql);
            if(rs.next()){
            	Valkyries v =new Valkyries();
                v.setNo(rs.getString("no"));
                v.setName(rs.getString("name"));
                v.setRatings(rs.getString("ratings"));
                v.setLevel(rs.getInt("level"));
                v.setWeapon(rs.getString("weapon"));
                v.setUpperStigmata(rs.getString("upperStigmata"));
                v.setCentreStigmata(rs.getString("centreStigmata"));
                v.setLowerStigmata(rs.getString("lowerStigmata"));
                state.close();
                conn.close();
                return v;
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