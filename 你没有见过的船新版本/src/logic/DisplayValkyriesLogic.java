package logic;

import java.util.ArrayList;

import javax.swing.JFrame;

import db.Application.lmp.ValkyriesService;
import db.Domain.Valkyries;
import display.AddValkyries;
import display.DisplayValkyries;
import display.EditValkyries;
import generic.Help.Keys;

public class DisplayValkyriesLogic {
	DisplayValkyries display;
	ValkyriesService service;
	ArrayList<Valkyries> valkyries;
	public DisplayValkyriesLogic(DisplayValkyries display){
		this.display = display;	
		service = new ValkyriesService();
		valkyries = service.GetAll();
	}

	public void output(){
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

	public void previous(){
		Keys.ValkyriesCurrsor--;
		if(Keys.ValkyriesCurrsor>=0){
			output();
		}
		else{
			Keys.ValkyriesCurrsor = 0;
		}
	}
	
	public void next(){
		Keys.ValkyriesCurrsor++;
		if(Keys.ValkyriesCurrsor<valkyries.size()){
			output();
		}
		else{
			Keys.ValkyriesCurrsor = valkyries.size()-1;
		}
	}
	public void refresh(){
		valkyries.clear();
		valkyries = service.GetAll();
		output();
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
