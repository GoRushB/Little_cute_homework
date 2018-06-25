package logic;

import javax.swing.JFrame;

import db.Student;
import db.StudentRepository;
import display.AddStudent;
import display.DisplayGradeByStudent;
import display.DisplayStudent;
import display.EditStudent;
import generic.CommonVariables;

import java.util.ArrayList;

public class DisplayStudentLogic {
	StudentRepository sr;
	ArrayList<Student> arrs;
	DisplayStudent ds;
	public DisplayStudentLogic(DisplayStudent ds){
		this.ds = ds;
		sr = new StudentRepository();
		arrs = sr.Retrieve();
	}
	
	public void init(){
		Student s = arrs.get(CommonVariables.StudentCurrsor);
		ds.txtStuSno.setText(s.getSno());
		ds.txtStuSname.setText(s.getSname());
		ds.txtStuSage.setText(String.valueOf((s.getSage())));
	}

	public void previous(){
		CommonVariables.StudentCurrsor--;
		if(CommonVariables.StudentCurrsor>=0){
			Student s = arrs.get(CommonVariables.StudentCurrsor);
			ds.txtStuSno.setText(s.getSno());
			ds.txtStuSname.setText(s.getSname());
			ds.txtStuSage.setText(String.valueOf((s.getSage())));
		}
		else{
			CommonVariables.StudentCurrsor = 0;
		}
	}
	
	public void next(){
		CommonVariables.StudentCurrsor++;
		int cur = CommonVariables.StudentCurrsor;
		if(cur<arrs.size()){
			Student s = arrs.get(cur);
			ds.txtStuSno.setText(s.getSno());
			ds.txtStuSname.setText(s.getSname());
			ds.txtStuSage.setText(String.valueOf((s.getSage())));
		}
		else{
			CommonVariables.StudentCurrsor = arrs.size()-1;
		}
	}
	
	public void refresh(){
		arrs.clear();
		arrs = sr.Retrieve();
	}
	
	public void OpenAddStudent(){
		AddStudent frame = new AddStudent();
		frame.setBounds(100,50,500,350);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	public void OpenEditStudent(){
		EditStudent frame = new EditStudent();
		frame.setBounds(100,50,500,350);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	public void OpenDisplayGradeByStudent() {
		DisplayGradeByStudent frame = new DisplayGradeByStudent();
		frame.setBounds(100,50,500,600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
}
