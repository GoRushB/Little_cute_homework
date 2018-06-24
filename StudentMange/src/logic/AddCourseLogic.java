package logic;

import db.Course;
import db.CourseRepository;
import display.AddCourse;

public class AddCourseLogic {
	private AddCourse addCourse;
	private CourseRepository cr;
	public AddCourseLogic(AddCourse ac){
		addCourse = ac;
		cr = new CourseRepository();
	}
	public boolean addCourse(String cno,String cname,double cprior){
		Course c = new Course();
		if(cr.getById(cno)!=null)
			return false;
		c.setCno(cno);
		c.setCname(cname);
		c.setCprior(cprior);
		cr.Create(c);
		addCourse.setVisible(false);
		return true;
	}
}
