package logic;

import java.util.ArrayList;

import db.Course;
import db.CourseRepository;
import display.EditCourse;
import generic.CommonVariables;

public class EditCourseLogic {
	EditCourse editCourse;
	CourseRepository sr;
	public EditCourseLogic(EditCourse editCourse) {
		this.editCourse = editCourse;
	}
	public void init(){
		ArrayList<Course> arrs = sr.Retrieve();
		Course c = arrs.get(CommonVariables.CourseCurrsor);
		editCourse.txtCouCno.setText(c.getCno());
		editCourse.txtCouCname.setText(c.getCname());
		editCourse.txtCouCprior.setText(String.valueOf((c.getCprior())));
	}
	public boolean Edit(String cname,double cprior){
		ArrayList<Course> arrs = sr.Retrieve();
		Course c = arrs.get(CommonVariables.CourseCurrsor);
		editCourse.txtCouCno.setText(c.getCno());
		c.setCname(cname);
		c.setCprior(cprior);
		sr.Updata(c, c);
		editCourse.setVisible(false);
		return true;
	}
	
	public boolean Delete(){
		ArrayList<Course> arrs = sr.Retrieve();
		Course c = arrs.get(CommonVariables.CourseCurrsor);
		sr.Delete(c);
		return true;
	}
}
