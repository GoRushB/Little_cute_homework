package logic;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import db.ACourseResult;
import db.Student;
import db.StudentRepository;
import db.StudentResult;
import display.DisplayGradeByStudent;
import generic.CommonVariables;

public class DisplayGradeByStudentLogic {
	DisplayGradeByStudent myframe;
	StudentRepository sr;
	public DisplayGradeByStudentLogic(DisplayGradeByStudent frame){
		myframe = frame;
		sr = new StudentRepository();
	}
	
	public void init(){
		ArrayList<Student> list1 = sr.Retrieve(); 
		Student s = list1.get(CommonVariables.StudentCurrsor);
		myframe.txtSno.setText(s.getSno());
		myframe.txtSname.setText(s.getSname());
		myframe.txtSage.setText(String.valueOf(s.getSage()));
		StudentResult studentResult = new StudentResult(s.getSno());
		ArrayList<ACourseResult> courses = studentResult.getCourses();
		DefaultListModel dlm = new DefaultListModel();
		for(ACourseResult aCourseResult : courses){
			dlm.addElement("      "+aCourseResult.getCno()+"        "+aCourseResult.getCname()+"         "+String.valueOf(aCourseResult.getCprior())+"          "+String.valueOf(aCourseResult.getGrade()));
		}
		myframe.courses.setModel(dlm);
	}
}
