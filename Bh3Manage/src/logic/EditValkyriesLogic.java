package logic;

import java.util.ArrayList;

import db.Valkyries;
import db.ValkyriesRepository;
import display.EditValkyries;
import generic.CommonVariables;

public class EditValkyriesLogic {
	EditValkyries editValkyries;
	ValkyriesRepository vr;
	public EditValkyriesLogic(EditValkyries editValkyries) {
		this.editValkyries = editValkyries;
		vr = new ValkyriesRepository();
	}
	public void init(){
		ArrayList<Valkyries> arrs = vr.Retrieve();
		Valkyries v = arrs.get(CommonVariables.ValkyriesCurrsor);
		editValkyries.txtno.setText(v.getNo());
		editValkyries.txtname.setText(v.getName());
		editValkyries.txtratings.setText(v.getRatings());
		editValkyries.txtlevel.setText(String.valueOf(v.getLevel()));
		editValkyries.txtweapon.setText(v.getWeapon());
		editValkyries.txtupperStigmata.setText(v.getUpperStigmata());
		editValkyries.txtcentreStigmata.setText(v.getCentreStigmata());
		editValkyries.txtlowerStigmata.setText(v.getLowerStigmata());
	}
	public boolean Edit(String name,String ratings,int level,String weapon,String upperStigmata,String centreStigmata,String lowerStigmata){
		ArrayList<Valkyries> arrs = vr.Retrieve();
		Valkyries v = arrs.get(CommonVariables.ValkyriesCurrsor);
		editValkyries.txtno.setText(v.getNo());
		v.setName(name);
		v.setRatings(ratings);
		v.setLevel(level);
		v.setWeapon(weapon);
		v.setUpperStigmata(upperStigmata);
		v.setCentreStigmata(centreStigmata);
		v.setLowerStigmata(lowerStigmata);
		vr.Updata(v, v);
		editValkyries.setVisible(false);
		return true;
	}
	
	public boolean Delete(){
		ArrayList<Valkyries> arrs = vr.Retrieve();
		Valkyries v = arrs.get(CommonVariables.ValkyriesCurrsor);
		vr.Delete(v);
		return true;
	}
}