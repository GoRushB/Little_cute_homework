package logic;

import db.Valkyries;
import db.ValkyriesRepository;
import display.AddValkyries;

public class AddValkyriesLogic {
	private AddValkyries addValkyries;
	private ValkyriesRepository vr;
	public AddValkyriesLogic(AddValkyries av){
		addValkyries = av;
		vr = new ValkyriesRepository();
	}
	public boolean addCourse(String no,String name,String ratings,int level,String weapon,String upperStigmata,String centreStigmata,String lowerStigmata){
		Valkyries v = new Valkyries();
		if(vr.getById(no)!=null)
			return false;
		v.setNo(no);
		v.setName(name);
		v.setRatings(ratings);
		v.setLevel(level);
		v.setWeapon(weapon);
		v.setUpperStigmata(upperStigmata);
		v.setCentreStigmata(centreStigmata);
		v.setLowerStigmata(lowerStigmata);
		vr.Create(v);
		addValkyries.setVisible(false);
		return true;
	}
}
