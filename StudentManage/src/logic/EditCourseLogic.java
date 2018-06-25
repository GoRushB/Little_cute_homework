package logic;

import java.util.ArrayList;

import db.Course;
import db.CourseRepository;
import display.EditCourse;
import generic.CommonVariables;

public class EditCourseLogic {
	EditCourse editCourse;
	CourseRepository cr;
	public EditCourseLogic(EditCourse editCourse) {
		this.editCourse = editCourse;
		cr = new CourseRepository();
	}
	public void init(){
		ArrayList<Course> arrs = cr.Retrieve();
		Course c = arrs.get(CommonVariables.CourseCurrsor);
		editCourse.txtCouCno.setText(c.getCno());
		editCourse.txtCouCname.setText(c.getCname());
		editCourse.txtCouCprior.setText(String.valueOf((c.getCprior())));
	}
	public boolean Edit(String cname,double cprior){
		ArrayList<Course> arrs = cr.Retrieve();
		Course c = arrs.get(CommonVariables.CourseCurrsor);
		editCourse.txtCouCno.setText(c.getCno());
		c.setCname(cname);
		c.setCprior(cprior);
		cr.Updata(c, c);
		editCourse.setVisible(false);
		return true;
	}
	
	public boolean Delete(){
		ArrayList<Course> arrs = cr.Retrieve();
		Course c = arrs.get(CommonVariables.CourseCurrsor);
		cr.Delete(c);
		return true;
	}
}
