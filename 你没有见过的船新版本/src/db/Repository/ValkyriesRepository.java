package db.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.Domain.Valkyries;
import db.Map.ValkyriesMap;
import generic.IRepository;
import generic.VisitDb;

public class ValkyriesRepository implements IRepository{

	public boolean IsExisted(Object identifier) {
		if(FindOne(identifier) == null)
			return false;
		return true;
	}

	public void Remove(Object identifier) {
		VisitDb.Establish();
		VisitDb.ExecuteInvoke(ValkyriesMap.Delete((String)identifier));
		VisitDb.Close();
	}

	public Object Save(Object entity) {
		Valkyries v = (Valkyries) entity;
		VisitDb.Establish();
		VisitDb.ExecuteInvoke(ValkyriesMap.Edit(
				v.No, v.Name, v.Ratings, v.Level, v.Weapon, v.UpperStigmata, v.CentreStigmata, v.LowerStigmata));
		VisitDb.Close();
		return v;
	}

	public Object FindOne(Object identifier) {
		VisitDb.Establish();
		ResultSet rs = VisitDb.ExecuteQueryInvoke(ValkyriesMap.Get((String)identifier));
		try {
			if(rs.next()){
				Valkyries v =new Valkyries(rs.getString("no"));
			    v.Name=(rs.getString("name"));
			    v.Ratings=(rs.getString("ratings"));
			    v.Level=(rs.getInt("level"));
			    v.Weapon=(rs.getString("weapon"));
			    v.UpperStigmata=(rs.getString("upperStigmata"));
			    v.CentreStigmata=(rs.getString("centreStigmata"));
			    v.LowerStigmata=(rs.getString("lowerStigmata"));
				rs.close();
			    VisitDb.Close();
			    return v;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		VisitDb.Close();
		return null;
	}

	public ArrayList<Object> FindAll() {
        ArrayList<Valkyries> arrs = new ArrayList<>();
		VisitDb.Establish();
		ResultSet rs = VisitDb.ExecuteQueryInvoke(ValkyriesMap.GetAll());
		try {
			if(rs.next()){
				Valkyries v =new Valkyries(rs.getString("no"));
			    v.Name=(rs.getString("name"));
			    v.Ratings=(rs.getString("ratings"));
			    v.Level=(rs.getInt("level"));
			    v.Weapon=(rs.getString("weapon"));
			    v.UpperStigmata=(rs.getString("upperStigmata"));
			    v.CentreStigmata=(rs.getString("centreStigmata"));
			    v.LowerStigmata=(rs.getString("lowerStigmata"));
			    arrs.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		VisitDb.Close();
		return null;
	}	
}
