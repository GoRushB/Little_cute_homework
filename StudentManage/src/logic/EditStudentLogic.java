package logic;

import java.util.ArrayList;

import db.Student;
import db.StudentRepository;
import display.EditStudent;
import generic.CommonVariables;

public class EditStudentLogic {
	EditStudent editStudent;
	StudentRepository sr;
	public EditStudentLogic(EditStudent editStudent) {
		this.editStudent = editStudent;
		sr = new StudentRepository();
	}
	public void init(){
		ArrayList<Student> arrs = sr.Retrieve();
		Student s = arrs.get(CommonVariables.StudentCurrsor);
		editStudent.txtStuSno.setText(s.getSno());
		editStudent.txtStuSname.setText(s.getSname());
		editStudent.txtStuSage.setText(String.valueOf((s.getSage())));
	}
	public boolean Edit(String sname,int sage){
		ArrayList<Student> arrs = sr.Retrieve();
		Student s = arrs.get(CommonVariables.StudentCurrsor);
		editStudent.txtStuSno.setText(s.getSno());
		s.setSname(sname);
		s.setSage(sage);
		sr.Updata(s, s);
		editStudent.setVisible(false);
		return true;
	}
	
	public boolean Delete(){
		ArrayList<Student> arrs = sr.Retrieve();
		Student s = arrs.get(CommonVariables.StudentCurrsor);
		sr.Delete(s);
		return true;
	}
}
