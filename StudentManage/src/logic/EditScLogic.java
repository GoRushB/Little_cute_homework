package logic;

import java.util.ArrayList;

import db.Sc;
import db.ScRepository;
import display.EditSc;
import generic.CommonVariables;

public class EditScLogic {
	EditSc editSc;
	ScRepository sr;
	public EditScLogic(EditSc editSc) {
		this.editSc = editSc;
		sr = new ScRepository();
	}
	public void init(){
		ArrayList<Sc> arrs = sr.Retrieve();
		Sc s = arrs.get(CommonVariables.ScCurrsor);
		editSc.txtScSno.setText(s.getSno());
		editSc.txtScCno.setText(s.getCno());
		editSc.txtScGrade.setText(String.valueOf((s.getGrade())));
		editSc.txtScScid.setText(String.valueOf((s.getScid())));
	}
	public boolean Edit(String Sno,String cno,double grade){
		ArrayList<Sc> arrs = sr.Retrieve();
		Sc s = arrs.get(CommonVariables.ScCurrsor);
		editSc.txtScScid.setText(String.valueOf((s.getScid())));
		s.setSno(Sno);
		s.setCno(cno);
		s.setGrade(grade); 
		sr.Updata(s, s);
		editSc.setVisible(false);
		return true;
	}
	
	public boolean Delete(){
		ArrayList<Sc> arrs = sr.Retrieve();
		Sc s = arrs.get(CommonVariables.ScCurrsor);
		sr.Delete(s);
		return true;
	}
}
