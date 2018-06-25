package logic;

import java.util.ArrayList;

import javax.swing.JFrame;

import db.Valkyries;
import db.ValkyriesRepository;
import display.AddValkyries;
import display.DisplayValkyries;
import display.EditValkyries;
import generic.CommonVariables;

public class DisplayValkyriesLogic {
	ValkyriesRepository vr;
	ArrayList<Valkyries> arrs;
	DisplayValkyries dv;
	public DisplayValkyriesLogic(DisplayValkyries dv){
		this.dv = dv;
		vr = new ValkyriesRepository();
		arrs = vr.Retrieve();
	}
	
	public void init(){
		Valkyries v = arrs.get(CommonVariables.ValkyriesCurrsor);
		dv.txtno.setText(v.getNo());
		dv.txtname.setText(v.getName());
		dv.txtratings.setText(v.getRatings());
		dv.txtlevel.setText(String.valueOf(v.getLevel()));
		dv.txtweapon.setText(v.getWeapon());
		dv.txtupperStigmata.setText(v.getUpperStigmata());
		dv.txtcentreStigmata.setText(v.getCentreStigmata());
		dv.txtlowerStigmata.setText(v.getLowerStigmata());
	}

	public void previous(){
		CommonVariables.ValkyriesCurrsor--;
		if(CommonVariables.ValkyriesCurrsor>=0){
			Valkyries v = arrs.get(CommonVariables.ValkyriesCurrsor);
			dv.txtno.setText(v.getNo());
			dv.txtname.setText(v.getName());
			dv.txtratings.setText(v.getRatings());
			dv.txtlevel.setText(String.valueOf(v.getLevel()));
			dv.txtweapon.setText(v.getWeapon());
			dv.txtupperStigmata.setText(v.getUpperStigmata());
			dv.txtcentreStigmata.setText(v.getCentreStigmata());
			dv.txtlowerStigmata.setText(v.getLowerStigmata());
		}
		else{
			CommonVariables.ValkyriesCurrsor = 0;
		}
	}
	
	public void next(){
		CommonVariables.ValkyriesCurrsor++;
		if(CommonVariables.ValkyriesCurrsor<arrs.size()){
			Valkyries v = arrs.get(CommonVariables.ValkyriesCurrsor);
			dv.txtno.setText(v.getNo());
			dv.txtname.setText(v.getName());
			dv.txtratings.setText(v.getRatings());
			dv.txtlevel.setText(String.valueOf(v.getLevel()));
			dv.txtweapon.setText(v.getWeapon());
			dv.txtupperStigmata.setText(v.getUpperStigmata());
			dv.txtcentreStigmata.setText(v.getCentreStigmata());
			dv.txtlowerStigmata.setText(v.getLowerStigmata());
		}
		else{
			CommonVariables.ValkyriesCurrsor = arrs.size()-1;
		}
	}
	
	public void refresh(){
		arrs.clear();
		arrs = vr.Retrieve();
	}
	
	public void OpenAddCourse(){
		AddValkyries frame = new AddValkyries();
		frame.setBounds(100,50,550,550);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	public void OpenEditCourse(){
		EditValkyries frame = new EditValkyries();
		frame.setBounds(100,50,550,550);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
}
