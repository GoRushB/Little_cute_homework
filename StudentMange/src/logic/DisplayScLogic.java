package logic;

import java.util.ArrayList;

import javax.swing.JFrame;

import db.Sc;
import db.ScRepository;
import display.AddSc;
import display.DisplaySc;
import display.EditSc;
import generic.CommonVariables;

public class DisplayScLogic {
	ScRepository sr;
	ArrayList<Sc> arrs;
	DisplaySc ds;
	public DisplayScLogic(DisplaySc ds){
		this.ds = ds;
		sr = new ScRepository();
		arrs = sr.Retrieve();
	}
	
	public void init(){
		Sc s = arrs.get(CommonVariables.ScCurrsor);
		ds.txtScSno.setText(s.getSno());
		ds.txtScCno.setText(s.getCno());
		ds.txtScGrade.setText(String.valueOf((s.getGrade())));
		ds.txtScScid.setText(String.valueOf((s.getScid())));
	}

	public void previous(){
		CommonVariables.ScCurrsor--;
		if(CommonVariables.ScCurrsor>=0){
			Sc s = arrs.get(CommonVariables.ScCurrsor);
			ds.txtScSno.setText(s.getSno());
			ds.txtScCno.setText(s.getCno());
			ds.txtScGrade.setText(String.valueOf((s.getGrade())));
			ds.txtScScid.setText(String.valueOf((s.getScid())));
		}
		else{
			CommonVariables.ScCurrsor = 0;
		}
	}
	
	public void next(){
		CommonVariables.ScCurrsor++;
		if(CommonVariables.ScCurrsor<arrs.size()){
			Sc s = arrs.get(CommonVariables.ScCurrsor);
			ds.txtScSno.setText(s.getSno());
			ds.txtScCno.setText(s.getCno());
			ds.txtScGrade.setText(String.valueOf((s.getGrade())));
			ds.txtScScid.setText(String.valueOf((s.getScid())));
		}
		else{
			CommonVariables.ScCurrsor = arrs.size()-1;
		}
	}
	
	public void refresh(){
		arrs.clear();
		arrs = sr.Retrieve();
	}
	
	public void OpenAddSc(){
		AddSc frame = new AddSc();
		frame.setBounds(100,50,500,350);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	public void OpenEditSc(){
		EditSc frame = new EditSc();
		frame.setBounds(100,50,500,350);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
}