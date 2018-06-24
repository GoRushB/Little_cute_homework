package logic;

import javax.swing.JFrame;

import db.Course;
import db.CourseRepository;
import display.AddCourse;
import display.DisplayCourse;
import display.EditCourse;
import generic.CommonVariables;

import java.util.ArrayList;

public class DisplayCourseLogic {
	CourseRepository cr;
	ArrayList<Course> arrs;
	DisplayCourse dc;
	public DisplayCourseLogic(DisplayCourse dc){
		this.dc = dc;
		cr = new CourseRepository();
		arrs = cr.Retrieve();
	}
	
	public void init(){
		Course c = arrs.get(CommonVariables.CourseCurrsor);
		dc.txtCouCno.setText(c.getCno());
		dc.txtCouCname.setText(c.getCname());
		dc.txtCouCprior.setText(String.valueOf((c.getCprior())));
	}

	public void previous(){
		CommonVariables.CourseCurrsor--;
		if(CommonVariables.CourseCurrsor>=0){
			Course c = arrs.get(CommonVariables.CourseCurrsor);
			dc.txtCouCno.setText(c.getCno());
			dc.txtCouCname.setText(c.getCname());
			dc.txtCouCprior.setText(String.valueOf((c.getCprior())));
		}
		else{
			CommonVariables.CourseCurrsor = 0;
		}
	}
	
	public void next(){
		CommonVariables.CourseCurrsor++;
		if(CommonVariables.CourseCurrsor<arrs.size()){
			Course c = arrs.get(CommonVariables.CourseCurrsor);
			dc.txtCouCno.setText(c.getCno());
			dc.txtCouCname.setText(c.getCname());
			dc.txtCouCprior.setText(String.valueOf((c.getCprior())));
		}
		else{
			CommonVariables.CourseCurrsor = arrs.size()-1;
		}
	}
	
	public void refresh(){
		arrs.clear();
		arrs = cr.Retrieve();
	}
	
	public void OpenAddCourse(){
		AddCourse frame = new AddCourse();
		frame.setBounds(100,50,500,350);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	public void OpenEditCourse(){
		EditCourse frame = new EditCourse();
		frame.setBounds(100,50,500,350);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
}
