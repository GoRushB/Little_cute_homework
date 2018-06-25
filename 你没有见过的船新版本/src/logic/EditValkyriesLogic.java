package logic;

import java.util.ArrayList;

import db.Domain.Valkyries;
import db.Application.lmp.ValkyriesService;
import display.EditValkyries;
import generic.Help.Keys;

public class EditValkyriesLogic {
	EditValkyries display;
	ValkyriesService service;
	ArrayList<Valkyries> valkyries;
	public EditValkyriesLogic(EditValkyries display) {
		this.display = display;
		service = new ValkyriesService();
		valkyries = service.GetAll();
	}
	public void init(){
		Valkyries v = valkyries.get(Keys.ValkyriesCurrsor);
		display.txtno.setText(v.No);
		display.txtname.setText(v.Name);
		display.txtratings.setText(v.Ratings);
		display.txtlevel.setText(String.valueOf(v.Level));
		display.txtweapon.setText(v.Weapon);
		display.txtupperStigmata.setText(v.UpperStigmata);
		display.txtcentreStigmata.setText(v.CentreStigmata);
		display.txtlowerStigmata.setText(v.LowerStigmata);
	}
	public void Edit(String no,String name,String ratings,int level,String weapon,String upperStigmata,String centreStigmata,String lowerStigmata){
		try {
			service.Edit(no)
			.Name(name)
			.Ratings(ratings)
			.Ratings(ratings)
			.Level(level)
			.Weapon(weapon)
			.UpperStigmata(upperStigmata)
			.CentreStigmata(centreStigmata)
			.LowerStigmata(lowerStigmata)
			.Save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		display.setVisible(false);
	}
	
	public void Delete(String no){
		service.Delete(no);
		display.setVisible(false);
	}
}