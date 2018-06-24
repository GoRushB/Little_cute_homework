package logic;

import db.Sc;
import db.ScRepository;
import display.AddSc;

public class AddScLogic {
	private AddSc addSc;
	private ScRepository sr;
	public AddScLogic(AddSc as){
		addSc = as;
		sr = new ScRepository();
	}
	public boolean addSc(String sno,String cno,double grade){
		Sc s = new Sc();
		if(sr.getById(sno)!=null)
			return false;
		s.setSno(sno);
		s.setCno(cno);
		s.setGrade(grade);
		sr.Create(s);
		addSc.setVisible(false);
		return true;
	}
}
