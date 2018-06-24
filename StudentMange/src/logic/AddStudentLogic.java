package logic;

import db.Student;
import db.StudentRepository;
import display.AddStudent;

public class AddStudentLogic {
	private AddStudent addStudent;
	private StudentRepository sr;
	public AddStudentLogic(AddStudent as){
		addStudent = as;
		sr = new StudentRepository();
	}
	public boolean addStudent(String sno,String sname,int sage){
		Student s = new Student();
		if(sr.getById(sno)!=null)
			return false;
		s.setSno(sno);
		s.setSname(sname);
		s.setSage(sage);
		sr.Create(s);
		addStudent.setVisible(false);
		return true;
	}
}
