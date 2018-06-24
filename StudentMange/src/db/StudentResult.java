package db;

import java.util.ArrayList;

public class StudentResult {
	private String sno;
	private ArrayList<ACourseResult> courses;
	public StudentResult(String sno){
		this.sno = sno;
	}
	private void InitCourses(){
		courses = new ArrayList<>();
		ScRepository scr = new ScRepository();
		CourseRepository cr = new CourseRepository();
		ArrayList<Sc> sclist = scr.Retrieve();
		ArrayList<Course> clist = cr.Retrieve();
		for(Sc sc : sclist){
			if(sc.getSno().equals(sno)){
				ACourseResult acr = new ACourseResult();
				acr.setCno(sc.getCno());
				acr.setGrade(sc.getGrade());
				for(Course course : clist){
					if(course.getCno().equals(sc.getCno())){
						acr.setCname(course.getCname());
						acr.setCprior(course.getCprior());
						break;
					}
				}
				courses.add(acr);
			}
		}
	}
	public ArrayList<ACourseResult> getCourses() {
		InitCourses();
		return courses;
	}
}
